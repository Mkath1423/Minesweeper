package minesweeper.gametypes;

import com.jogamp.opengl.GL2;

import engine.drawables.Quad;
import minesweeper.Constants.kTile;;

public class Tile {
    public Quad outline;
    public Quad inner;

    public int x;
    public int y;
    public float l;

    public boolean isHidden;
    public boolean isBomb;
    public int count;

    public Tile(int _x, int _y, int _l){
        x = _x*_l;
        y = _y*_l;
        l = _l;

        isHidden = true;
        isBomb = false;
        count = 0;

        outline = Quad.Square(x, y, _l, kTile.boarderColor);
        inner   = Quad.Square(x + (l * kTile.boarderPercent / 2), 
                              y + (l * kTile.boarderPercent / 2), 
                              l * kTile.boarderPercent, 
                              kTile.innerColor);
    }

    public void draw(GL2 gl){
        if(!isHidden && isBomb){
            outline.draw(gl);
            inner.draw(gl);
            // bomb sprite
        }
        else if(!isHidden && !isBomb){
            outline.draw(gl);
            inner.draw(gl);
            // number sprite
        }
        else if(isHidden){
            outline.draw(gl);
            inner.draw(gl);
            // hidden sprite
        }
    }
}
