package engine.rendering.geometry;

import com.jogamp.opengl.GL2;

import engine.rendering.Drawable;

public class Triangle implements Drawable{

    public Point A;
    public Point B;
    public Point C;

    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void draw(GL2 gl) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }
    
}
