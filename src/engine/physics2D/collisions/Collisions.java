package engine.physics2D.collisions;

import engine.rendering.geometry.Point;
import engine.rendering.geometry.Quad;
import engine.rendering.geometry.Triangle;

public class Collisions {
    /** 
     * Determines if there is an intersection between a quad and a point
     * 
     * Calculates the area of the quad.
     * Calculates the total area of the 4 triangles constructed from each side of the quad and the point.
     * 
     * If the areas are the same, the point is within the quad
     * 
     * @warning this does not work for concave quadrilaterals 
     * 
     * @param q the quadrilateral 
     * @param p the test point
     * @return boolean true if the point is inside the quad
     */
    public static boolean QuadPoint(Quad q, Point p){
        return Area.quad(q) == Area.triangle(new Triangle(q.left_bottom,  q.left_top,     p)) +
                               Area.triangle(new Triangle(q.left_top,     q.right_top,    p)) +
                               Area.triangle(new Triangle(q.right_top,    q.right_bottom, p)) +
                               Area.triangle(new Triangle(q.right_bottom, q.left_bottom,  p)) ;
    }
    
    
    /** 
     * Determines if there is an intersection between a square and a point
     * 
     * Checks if the x and y position of the point is bounded by the sides of the square.
     * 
     * @warning the will not work if the quad is not rectangular
     * 
     * @param q the square 
     * @param p the test point
     * @return boolean true if the point is inside the quad
     */
    public static boolean RectPoint(Quad q, Point p){
        return p.x > q.left_bottom.x  && 
               p.x < q.right_bottom.x && 
               p.y < q.left_bottom.y  && 
               p.y > q.left_top.y;
    }
}
