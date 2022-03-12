package engine.rendering.geometry;

/**
 * A Quadrilateral
 * 
 * Contains the vertices of a quad
 * 
 * Methods:
 *  Square -> constructs a square
 *  Rectangle -> constructs a rectangle
 *  Shift -> shits the vertices of the quad
 *  toString -> generates a string representation of the quad
 */
public class Quad {
    public Point left_top;
    public Point right_top;
    public Point left_bottom;
    public Point right_bottom;

    /**
     * Constructs a quad from vertices 
     * 
     * @param lt top left point
     * @param lb bottom left point
     * @param rb bottom right point
     * @param rt top right point
     */
    public Quad(Point lt, Point lb, Point rb, Point rt){
        left_top = lt;
        left_bottom = lb;
        right_bottom = rb;
        right_top = rt;
    }

    
    /** 
     * Creates a square quad
     * 
     * Constructs a quad with the vertices of a square
     * 
     * @param x top left x value
     * @param y top left y value
     * @param l length of sides
     * @return the square 
     */
    public static Quad Square(float x, float y, float l){
        return new Quad(
            new Point(x    , y    ),
            new Point(x    , y + l),
            new Point(x + l, y + l),
            new Point(x + l, y    )
        );
    }

    
    /** 
     * Creates a rectangular quad
     * 
     * Constructs a quad with the vertices of a rectangle
     * 
     * @param x top left x value
     * @param y top left y value
     * @param w width of the rectangle
     * @param h height of the rectangle
     * @return the Rectangle
     */
    public static Quad Rectangle(float x, float y, float w, float h){
        return new Quad(
            new Point(x    , y    ),
            new Point(x    , y + h),
            new Point(x + w, y + h),
            new Point(x + w, y    )
        );
    }

    
    /** 
     * Shifts the quad by a specified amount
     * 
     * Moves all vertices by the specified amount
     * 
     * @param x the x distance
     * @param y the y distance
     */
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

    
    /**
     * Turns the quad into a string
     * 
     * Outputs string in the format: (lt, lb, rb, rt)
     * 
     * @return a string representing the quad
     */
    public String toString(){
        return String.format("Quad(lt:%s, lb:%s, rb:%s, rt:%s)", left_top.toString(), left_bottom.toString(), right_bottom.toString(), right_top.toString());
    }
}
