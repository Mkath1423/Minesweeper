package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;
import minesweeper.util.GameUtils;
import engine.utils.Point;

public class EventListener implements GLEventListener{
    public Tile tile;

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        tile.draw(gl);

    
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        
        System.out.println("dispose");
    }

    @Override
    public void init(GLAutoDrawable drawable){
        GL2 gl = drawable.getGL().getGL2();
        tile = new Tile(40, 10, 10);

        System.out.println("finished init");

        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        
        gl.glLoadIdentity();

        gl.glOrtho(0, w, 0, h, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        System.out.println("reshape");
    }
    
}
