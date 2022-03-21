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

    // 2d position of the point
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

    /**
     * Checks if a point is equal to this
     * 
     * @return true if the x and y are the same
     */
    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        if(o == this) return true;

        Point that = (Point)o;
        
        return this.x  == that.x &&
               this.y  == that.y;
    }
}
