package engine.rendering.drawables;

import com.jogamp.opengl.GL2;

import engine.rendering.Drawer;

public interface Drawable {
    
    // Important: use this in implementaions
    //int index = -1;
    //String layer = "";

    public void init();
    public void draw(GL2 gl);
    public void dispose();
    public void reshape(int x, int y, int w, int h);
}
