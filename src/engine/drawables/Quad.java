package engine.drawables;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import engine.rendering.Drawer;
import engine.utils.Color;
import engine.utils.Point;

public class Quad implements Drawable{
    public Point left_top;
    public Point right_top;
    public Point left_bottom;
    public Point right_bottom;

    public Color color;

    public Quad(Point lb, Point rb, Point rt, Point lt){
        left_top = lt;
        right_top = lb;
        left_bottom = rt;
        right_bottom = rb;

        color = new Color(1f, 1f, 1f, 1f);
    }

    public Quad(Point lb, Point rb, Point rt, Point lt, Color _color){
        left_top = lt;
        right_top = lb;
        left_bottom = rt;
        right_bottom = rb;

        color = _color;
    }

    public static Quad Square(float x, float y, float l, Color color){
        return new Quad(
            new Point(x    , y    ),
            new Point(x + l, y    ),
            new Point(x + l, y + l),
            new Point(x    , y + l),
            color
        );
    }

    public void shift(float x, float y){
        left_top.x     += x;
        left_top.y     += y;

        right_top.x    += x;
        right_top.y    += y;

        left_bottom.x  += x;
        left_bottom.y  += y;

        right_bottom.x += x;
        right_bottom.y += y;
    }

    @Override
    public void init(Drawer d) {
        index = d.Frame(layer).add(this);
        
    }

    @Override
    public void draw(GL2 gl) {

        gl.glBegin(GL2.GL_QUADS);

        gl.glColor4f(color.r, color.g, color.b, color.a);

        gl.glVertex2f(left_top.x,     left_top.y);
        gl.glVertex2f(left_bottom.x,  left_bottom.y);
        gl.glVertex2f(right_bottom.x, right_bottom.y);
        gl.glVertex2f(right_top.x,    right_top.y);

        gl.glEnd();
    }


    @Override
    public void dispose(Drawer d) {
        d.Frame(layer).remove(index);
    }

    @Override
    public void reshape(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    
}
