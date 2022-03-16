package engine.rendering;

import com.jogamp.opengl.GL2;

import engine.rendering.geometry.Quad;
import engine.resourse.Sprite;

public interface Drawable {
    
    /**
     * Initialize the drawable with the Drawer
     * 
     * Call this in the constructor
     * 
     * Add the drawable to a layer in the Drawer
     * 
     * Store the position in the layer for later
     */
    public void init();

    /**
     * Draw drawable to the gl context
     * 
     * Add logic for changing image in here
     * 
     * Gets called by the Drawer each frame
     * 
     * @param gl the gl context to draw to
     */
    // public void draw(GL2 gl);

    /**
     * Called when the window is disposed 
     * 
     */
    public void dispose();

    public Sprite GetSprite();
    public Quad GetQuad();

    /**
     * Called when the window is resized
     * 
     * @param x x position of screen
     * @param y y position of screen
     * @param w width of screen
     * @param h height of screen
     */
    public void reshape(int x, int y, int w, int h);
}
