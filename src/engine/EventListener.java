package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import engine.rendering.Drawer;

public class EventListener implements GLEventListener{
    public GameLoop gameLoop;

    public EventListener(GameLoop gameLoop){
        this.gameLoop = gameLoop;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Clear the screen
        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        
        gameLoop.update(1);
        Drawer.draw(gl);    
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");
        gameLoop.dispose();
    }

    @Override
    public void init(GLAutoDrawable drawable){
        GL2 gl = drawable.getGL().getGL2();

        gl.glEnable(GL2.GL_TEXTURE_2D);

        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);        
        
        gameLoop.init();
        gameLoop.loadTextures();
        System.out.println("finished init");
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        
        gl.glLoadIdentity();

        gl.glOrtho(0, w, h, 0, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        System.out.println("reshape");
    }   
}
