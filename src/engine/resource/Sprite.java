package engine.resource;

import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

/**
 * A sprite object
 * 
 * Contains 
 * - the texture to render
 * - the texture coordinates to map to the quad
 * - the url of the sprite map
 */
public class Sprite {
    // the openGL texture
    public Texture texture;

    // the url (used to sort the Sprites)
    public URL url;

    // the texture coordinates (values are from [0, 1])
    public Quad slice;

    /**
     * Constructs a sprite
     * 
     * uses the full texture
     * 
     * @param texture the gl texture
     * @param url the url from the image resource texture map
     */
    public Sprite(Texture texture, URL url){
        this.texture = texture;
        this.url = url;

        // creates Quad((0, 0), (0, 1), (1, 1), (1, 0))
        slice = Quad.Square(0, 0, 1);
    }

    /**
     * Constructs a sprite
     * 
     * Uses the specified texture coordinates 
     * 
     * @param texture the gl texture
     * @param url the url from the image resource texture map
     * @param slice the quad containing the texture coordinates
     */
    public Sprite(Texture texture, URL url, Quad slice){
        this.texture = texture;
        this.url = url;
        this.slice   = slice;
    }

    /**
     * Checks if the sprites are the same
     * 
     * @return true is the objects have the same url and slice
     */
    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        if(o == this) return true;

        Sprite that = (Sprite) o;
        return this.url.toString() == that.url.toString() &&
               this.slice == that.slice;
    }
}
