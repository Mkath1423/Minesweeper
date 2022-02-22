package engine.utils;

public class Color {
    public final float r;
    public final float b;
    public final float g;

    public final float a;

    public Color(float _r, float _b, float _g){
        r = _r;
        b = _b;
        g = _g;

        a = 1;
    }

    public Color(float _r, float _b, float _g, float _a){
        r = _r;
        b = _b;
        g = _g;

        a = _a;
    }

    public static Color RandomColor(){
        return new Color(
            (float)Math.random(),
            (float)Math.random(),
            (float)Math.random(),
                1
        );
    }
}
