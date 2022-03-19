package engine.resourse;

import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

public class SpriteMap {
    Texture texture = null;
    URL url;

    public boolean isSliced;

    public float cellsWide;
    public float cellsTall;

    public float cellWidth;
    public float cellHeight;

    public SpriteMap(Texture texture, URL url, float cellsWide, float cellsTall){
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;

        this.cellHeight = 1 / cellsTall;
        this.cellWidth  = 1 / cellsWide;

        this.isSliced = true;

        this.texture = texture;
        this.url = url;
    }

    public SpriteMap(Texture texture, URL url){
        this.texture = texture;
        this.url = url;
        
        this.isSliced = false;

        this.cellsWide = 0;
        this.cellsTall = 0;

        this.cellWidth = 0;
        this.cellHeight = 0;
    }

    public Sprite getSprite(){
        return new Sprite(texture, url);
    }

    public Sprite getSprite(int cell){
        if(!isSliced                  ) return getSprite();
        if(cell >= cellsWide*cellsTall) return null;
        if(cell <  0                  ) return null;
        
        int x = cell % (int)cellsWide;
        int y = cell / (int)cellsWide;
        
        return new Sprite(texture, url, Quad.Rectangle(x*cellWidth, y*cellHeight, cellWidth, cellHeight));
    }
}
