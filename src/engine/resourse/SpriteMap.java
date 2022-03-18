package engine.resourse;

import java.net.URL;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

public class SpriteMap {
    Texture texture = null;
    URL url;

    public boolean isSliced = false;

    public float cellsWide = 0;
    public float cellsTall = 0;

    public float cellWidth = 0;
    public float cellHeight = 0;

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
    }

    public Sprite getSprite(){
        return new Sprite(texture, url);
    }

    public Sprite getSprite(int cell){
        if(cell >= cellsWide*cellsTall) return null;
        if(cell <  0                  ) return null;
        if(!isSliced                  ) return getSprite();
        
        int x = cell % (int)cellsWide;
        int y = cell / (int)cellsWide;
        
        return new Sprite(texture, url, Quad.Rectangle(x*cellWidth, y*cellHeight, cellWidth, cellHeight));
    }
}
