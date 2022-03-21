package engine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import engine.rendering.Drawer;
import engine.scenes.SceneManager;

public class EventListener implements GLEventListener{

    // the game loop with the dev's code
    public GameLoop gameLoop;

    /**
     * Constructs an event listener
     * 
     * @param gameLoop the game loop
     */
    public EventListener(GameLoop gameLoop){
        this.gameLoop = gameLoop;
    }

    /**
     * Called every frame 
     * 
     * Invokes update methods 
     * 
     * Displays stuff to the gl context via Drawer
     * 
     * @param drawable the gl context
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL2 gl = drawable.getGL().getGL2();

        // Clear the screen
        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        
        // update the scene and gameloop
        SceneManager.Update(1);
        gameLoop.update(1);

        // draw everything
        Drawer.draw(gl);    
    }

    /**
     * Called when the window is closed
     * 
     * Invokes the dispose method
     * 
     * @param drawable the gl context
     */
    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");
        gameLoop.dispose();
    }

    /**
     * Called when the window starts
     * 
     * Initializes the game loop
     * 
     * @param drawable the gl context
     */
    @Override
    public void init(GLAutoDrawable drawable){
        GL2 gl = drawable.getGL().getGL2();

        // enable 2d texture rendering
        gl.glEnable(GL2.GL_TEXTURE_2D);

        // clear the screen
        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);        
        
        // Initialize the game loop
        gameLoop.loadTextures();
        gameLoop.init();
    }

    /**
     * Called when the window is resized
     * 
     * Invokes the reshape method (TODO: this)
     * 
     * @param drawable the gl context
     * @param x the x position of the window
     * @param y the y position of the window
     * @param w the   width    of the window
     * @param h the   height   of the window
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL2 gl = drawable.getGL().getGL2();

        // initializes gl ot change the projection settings
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Sets the projection mode to orthographic
        gl.glOrtho(0, w, h, 0, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        System.out.println("reshape");
    }   
}
