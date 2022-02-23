package engine.drawables;

import com.jogamp.opengl.GL2;

import engine.rendering.Drawer;

public interface Drawable {
    
    // Important: use this in implementaions
    //int index = -1;
    //String layer = "";

    public void init(Drawer d);
    public void draw(GL2 gl);
    public void dispose(Drawer d);
    public void reshape(int x, int y, int w, int h);
}
