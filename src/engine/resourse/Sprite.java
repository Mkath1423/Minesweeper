package engine.resourse;

import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

public class Sprite {
    public Texture texture;

    public URL url;

    public Quad slice;

    public Sprite(Texture texture, URL url){
        this.texture = texture;
        this.url = url;
        slice = Quad.Square(0, 0, 1);
    }

    public Sprite(Texture texture, URL url, Quad slice){
        this.texture = texture;
        this.url = url;
        this.slice   = slice;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        if(o == this) return true;

        Sprite that = (Sprite) o;
        return this.url.toString() == that.url.toString() &&
               this.slice == that.slice;
    }
}
