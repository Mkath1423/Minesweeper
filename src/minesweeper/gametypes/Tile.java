package minesweeper.gametypes;

import minesweeper.util.Quad;

import com.jogamp.opengl.GL2;

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

    public Tile(int _x, int _y, float _l){
        x = _x;
        y = _x;
        l = _l;

        isHidden = true;
        isBomb = false;
        count = 0;

        outline = Quad.Square(_x, _y, _l, kTile.boarderColor);
        inner   = Quad.Square(_x + (l * kTile.boarderPercent / 2), 
                              _y + (l * kTile.boarderPercent / 2), 
                              _l * kTile.boarderPercent, 
                              kTile.boarderColor);
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
