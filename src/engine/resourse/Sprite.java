package engine.resourse;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.color.Color;
import engine.rendering.geometry.Quad;

public class Sprite {
    public Texture texture;

    public Quad slice;

    public Sprite(Texture texture){
        this.texture = texture;

        slice = Quad.Square(0, 0, 1, new Color(0, 0, 0, 1));
    }

    public Sprite(Texture texture, Quad slice){
        this.texture = texture;
        this.slice   = slice;
    }
}
