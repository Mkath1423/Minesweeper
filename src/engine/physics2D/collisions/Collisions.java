package engine.physics2D.collisions;

import engine.rendering.geometry.Point;
import engine.rendering.geometry.Quad;
import engine.rendering.geometry.Triangle;

public class Collisions {

    public static boolean Quad_Point(Quad q, Point p){
        return Area.quad(q) == Area.triangle(new Triangle(q.left_bottom,  q.left_top,     p)) +
                               Area.triangle(new Triangle(q.left_top,     q.right_top,    p)) +
                               Area.triangle(new Triangle(q.right_top,    q.right_bottom, p)) +
                               Area.triangle(new Triangle(q.right_bottom, q.left_bottom,  p)) ;
    }
    
    public static boolean Square_Point(Quad q, Point p){
        return p.x > q.left_bottom.x  && 
               p.x < q.right_bottom.x && 
               p.y > q.left_bottom.y  && 
               p.y < q.left_top.y;
    }
}
