package engine.resourse;

import com.jogamp.opengl.util.texture.Texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

import engine.rendering.geometry.Quad;

import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

public class SpriteMap {
    Texture texture = null;

    public boolean isSliced = false;

    public float cellsWide = 0;
    public float cellsTall = 0;

    public float cellWidth = 0;
    public float cellHeight = 0;

    public SpriteMap(BufferedImage bf, float cellsWide, float cellsTall){
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;


        cellHeight = bf.getHeight() / cellsTall;
        cellWidth  = bf.getWidth()  / cellsWide;
    }

    public Sprite getTexture(){
        return new Sprite(texture);
    }

    public Sprite getTexture(int cell){
        if(!isSliced) getTexture();

        int x = cell % (int)cellsWide;
        int y = cell / (int)cellsTall;

        return new Sprite(texture, Quad.Rectangle(x*cellWidth, y*cellHeight, cellWidth, cellHeight));
        
    }
}
