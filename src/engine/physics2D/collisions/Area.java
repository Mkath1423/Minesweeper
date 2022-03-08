package engine.physics2D.collisions;

import engine.rendering.geometry.Point;
import engine.rendering.geometry.Quad;
import engine.rendering.geometry.Triangle;

public class Area {
    
    public static double trapazoid(Quad t){
        return Math.abs(((0.5 * (t.left_top.y + t.right_top.y)) - t.right_bottom.y) * (t.right_bottom.x - t.left_bottom.x));
    }

    public static double triangle(Triangle t){
        return trapazoid(new Quad(t.B, 
                                  t.A, 
                                  new Point(t.B.x, 0), 
                                  new Point(t.A.x, 0))) 
                +
               trapazoid(new Quad(t.A, 
                                  t.C, 
                                  new Point(t.A.x, 0), 
                                  new Point(t.C.x, 0)))
                -
               trapazoid(new Quad(t.B, 
                                  t.C, 
                                  new Point(t.B.x, 0), 
                                  new Point(t.C.x, 0)));
    }

    public static double quad(Quad q){
        return trapazoid(new Quad(q.left_bottom, 
                                  q.left_top, 
                                  new Point(q.left_bottom.x, 0), 
                                  new Point(q.left_top.x, 0))) 
                +
               trapazoid(new Quad(q.left_top, 
                                  q.right_top, 
                                  new Point(q.left_top.x, 0), 
                                  new Point(q.right_top.x, 0)))
                -
               trapazoid(new Quad(q.left_bottom, 
                                  q.right_bottom, 
                                  new Point(q.left_bottom.x, 0), 
                                  new Point(q.right_bottom.x, 0)))
                -
               trapazoid(new Quad(q.right_bottom, 
                                  q.right_top, 
                                  new Point(q.right_bottom.x, 0), 
                                  new Point(q.right_top.x, 0)));
    }
}
