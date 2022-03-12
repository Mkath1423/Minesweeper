package engine.rendering.geometry;

public class Point {
    public float x;
    public float y;

    public Point(float _x, float _y){
        x = _x;
        y = _y;
    }

    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
