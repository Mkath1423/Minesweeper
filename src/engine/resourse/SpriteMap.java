package engine.resourse;

import com.jogamp.opengl.util.texture.Texture;

import engine.rendering.geometry.Quad;

public class SpriteMap {
    Texture texture = null;

    public boolean isSliced = false;

    public float cellsWide = 0;
    public float cellsTall = 0;

    public float cellWidth = 0;
    public float cellHeight = 0;

    public SpriteMap(Texture texture, float cellsWide, float cellsTall){
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;

        this.cellHeight = 1 / cellsTall;
        this.cellWidth  = 1 / cellsWide;

        this.isSliced = true;

        this.texture = texture;
    }

    public SpriteMap(Texture texture){
        this.texture = texture;
    }

    public Sprite getSprite(){
        return new Sprite(texture);
    }

    public Sprite getSprite(int cell){
        if(cell >= cellsWide*cellsTall) return null;
        if(cell <  0) return null;

        if(!isSliced) return getSprite();
        
        int x = cell % (int)cellsWide;
        int y = cell / (int)cellsWide;
        
        return new Sprite(texture, Quad.Rectangle(x*cellWidth, y*cellHeight, cellWidth, cellHeight));
    }
}
