package engine.physics2D.collisions;

import engine.rendering.geometry.Point;
import engine.rendering.geometry.Quad;
import engine.rendering.geometry.Triangle;

public class Area {
    
    
    /** 
     * Calculates the area of a trapezoid
     * 
     * @warning this will not break if you give it a none trapezoid Quad. However, it will have the wrong area.
     * 
     * @param q a Quad containing the vertices of a trapezoid
     * @return double the area of the trapezoid
     * 
     * TODO: Testing
     */
    public static double trapezoid(Quad q){
        return Math.abs(((0.5 * (q.left_top.y + q.right_top.y)) - q.right_bottom.y) * (q.right_bottom.x - q.left_bottom.x));
    }

    
    /** 
     * Calculates the area of a triangle
     * 
     * Breaks down the triangle into three trapezoids with the x axis at the bottom.
     * Adds and subtracts them to get the correct area.
     * 
     * https://www.cuemath.com/geometry/area-of-triangle-in-coordinate-geometry/
     * 
     * @param t a Triangle containing the vertices of the triangle
     * @return double the area of the triangle
     * 
     * TODO: Testing
     */
    public static double triangle(Triangle t){
        return trapezoid(new Quad(t.B, 
                                  t.A, 
                                  new Point(t.B.x, 0), 
                                  new Point(t.A.x, 0))) 
                +
               trapezoid(new Quad(t.A, 
                                  t.C, 
                                  new Point(t.A.x, 0), 
                                  new Point(t.C.x, 0)))
                -
               trapezoid(new Quad(t.B, 
                                  t.C, 
                                  new Point(t.B.x, 0), 
                                  new Point(t.C.x, 0)));
    }

    
    /** 
     * Calculates the area of a triangle
     * 
     * Breaks down the quad into 4 trapezoids with the x axis at the bottom.
     * Adds and subtracts them to get the correct area.
     * 
     * https://www.cuemath.com/geometry/area-of-triangle-in-coordinate-geometry/
     * @param q Quad containing the vertices of the quadrilateral 
     * @return double the area of the triangle
     * 
     * TODO: Testing
     */
    public static double quad(Quad q){
        return trapezoid(new Quad(q.left_bottom, 
                                  q.left_top, 
                                  new Point(q.left_bottom.x, 0), 
                                  new Point(q.left_top.x, 0))) 
                +
               trapezoid(new Quad(q.left_top, 
                                  q.right_top, 
                                  new Point(q.left_top.x, 0), 
                                  new Point(q.right_top.x, 0)))
                -
               trapezoid(new Quad(q.left_bottom, 
                                  q.right_bottom, 
                                  new Point(q.left_bottom.x, 0), 
                                  new Point(q.right_bottom.x, 0)))
                -
               trapezoid(new Quad(q.right_bottom, 
                                  q.right_top, 
                                  new Point(q.right_bottom.x, 0), 
                                  new Point(q.right_top.x, 0)));
    }
}
