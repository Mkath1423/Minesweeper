package engine.rendering.color;


/**
 * A Color 
 * 
 * Stores RBGA values for a color
 * 
 * Methods:
 *  RandomColor -> generate a random color
 */
public class Color {
    public final float r;
    public final float b;
    public final float g;

    public final float a;

    /**
     * Creates a color object with the specified RGB value
     * 
     * alpha is defaulted to 1
     * 
     * @param _r red
     * @param _b green
     * @param _g blue
     */
    public Color(float _r, float _b, float _g){
        r = _r;
        b = _b;
        g = _g;

        a = 1;
    }

    /**
     * Creates a color object with the specified RGBA value
     * 
     * @param _r red
     * @param _b green
     * @param _g blue
     * @param _a alpha
     */
    public Color(float _r, float _b, float _g, float _a){
        r = _r;
        b = _b;
        g = _g;

        a = _a;
    }

    
    /** 
     * Creates a random color
     * 
     * Alpha is 1
     * RGB is between 0-1
     * 
     * @return Color a randomly generated color
     */
    public static Color RandomColor(){
        return new Color(
            (float)Math.random(),
            (float)Math.random(),
            (float)Math.random(),
                1
        );
    }
}
