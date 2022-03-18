package engine.rendering.geometry;

/**
 * A triangle
 * 
 * Contains the vertices of a triangle
 */
public class Triangle {

    public Point A;
    public Point B;
    public Point C;

    /**
     * Constructs a triangle with the given vertices
     * 
     * The order of the points is arbitrary 
     * 
     * @param A point A
     * @param B point B
     * @param C point C
     */
    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        if(o == this) return true;

        Triangle that = (Triangle)o;
        
        return this.A == that.A  &&
               this.B == that.B  &&
               this.C == that.C;
    } 
    
}
