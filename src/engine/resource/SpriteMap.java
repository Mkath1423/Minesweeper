package engine.resource;

import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

public class SpriteMap {
    Texture texture = null;
    URL url;

    // true if there are multiple sprites in the texture
    public boolean isSliced;

    // the amount of sprites in the texture
    public float cellsWide;
    public float cellsTall;

    // the size of one sprite (in texture coordinates)
    public float cellWidth;
    public float cellHeight;

    /**
     * Constructs a SpriteMap with multiple sprites
     * 
     * @param texture the GL texture
     * @param url the url from image resource
     * @param cellsWide the amount of cells in the x direction
     * @param cellsTall the amount of cells in the y direction
     */
    public SpriteMap(Texture texture, URL url, float cellsWide, float cellsTall){
        
        // Store the amount of cells
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;

        // calculate the cell size
        this.cellHeight = 1 / cellsTall;
        this.cellWidth  = 1 / cellsWide;

        this.isSliced = true;

        this.texture = texture;
        this.url = url;
    }

    /**
     * Constructs a SpriteMap with one sprites
     * 
     * @param texture the GL texture
     * @param url the url from image resource
     */
    public SpriteMap(Texture texture, URL url){

        // store the texture and url
        this.texture = texture;
        this.url = url;
        
        // the SpriteMap will only be one sprite 
        this.isSliced = false;

        // these values dont matter as they will not be used
        this.cellsWide = 0;
        this.cellsTall = 0;
        this.cellWidth = 0;
        this.cellHeight = 0;
    }

    /**
     * Creates and returns a Sprite 
     * 
     * The sprite will use the full texture 
     * 
     * @return the generated sprite
     */
    public Sprite getSprite(){
        return new Sprite(texture, url);
    }

    /**
     * Creates and returns a Sprite 
     * 
     * The sprite will use the specified cell in the SpriteMap
     * 
     * @return the generated sprite
     */
    public Sprite getSprite(int cell){
        // If its not a sliced sprite return the full image
        if(!isSliced                  ) return getSprite();

        // return null if the cell value is out of range
        if(cell >= cellsWide*cellsTall) return null;
        if(cell <  0                  ) return null;
        
        // calculate the x and y position (in units) of the specified index 
        int x = cell % (int)cellsWide;
        int y = cell / (int)cellsWide;
        
        // Generate and return the sprite with the correct slice of the image
        return new Sprite(texture, url, Quad.Rectangle(x*cellWidth, y*cellHeight, cellWidth, cellHeight));
    }
}
