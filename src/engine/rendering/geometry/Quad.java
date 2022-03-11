package engine.rendering.geometry;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;
import engine.rendering.Drawable;
import engine.rendering.Drawer;
import engine.rendering.LayerKeys;
import engine.rendering.color.Color;

public class Quad {
    public Point left_top;
    public Point right_top;
    public Point left_bottom;
    public Point right_bottom;

    public int index = -1;
    public LayerKeys layer = LayerKeys.DEFAULT;

    public Quad(Point lb, Point rb, Point rt, Point lt){
        left_top = lt;
        right_top = lb;
        left_bottom = rt;
        right_bottom = rb;
    }

    public static Quad Square(float x, float y, float l){
        return new Quad(
            new Point(x    , y    ),
            new Point(x + l, y    ),
            new Point(x + l, y + l),
            new Point(x    , y + l)
        );
    }

    public static Quad Rectangle(float x, float y, float w, float h){
        return new Quad(
            new Point(x    , y    ),
            new Point(x + w, y    ),
            new Point(x + w, y + h),
            new Point(x    , y + h)
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
}
