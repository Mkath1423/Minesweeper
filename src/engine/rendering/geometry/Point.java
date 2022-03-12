package engine.rendering.geometry;

/**
 * A Point
 * 
 * Stores an (x,y) pair
 * 
 * Methods:
 *  ToString -> Turns the point into a string
 */
public class Point {
    public float x;
    public float y;

    /**
     * Creates a point from x and y values
     * 
     * @param _x the x value of the point
     * @param _y the y value of the point
     */
    public Point(float _x, float _y){
        x = _x;
        y = _y;
    }

    /**
     * Turns the point into a string
     * 
     * Outputs string in the format: (x, y)
     * 
     * @return a string representing the point
     */
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
