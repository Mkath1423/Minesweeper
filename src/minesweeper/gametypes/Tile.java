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

    public Tile(int _x, int _y, float _l){
        x = _x;
        y = _x;
        l = _l;

        outline = Quad.Square(_x, _y, _l, kTile.boarderColor);
        inner   = Quad.Square(_x + (l * kTile.boarderPercent / 2), 
                              _y + (l * kTile.boarderPercent / 2), 
                              _l * kTile.boarderPercent, 
                              kTile.boarderColor);
    }

    public void draw(GL2 gl){
        outline.draw(gl);
        inner.draw(gl);
    }
}
