package minesweeper.gametypes;

import com.jogamp.opengl.GL2;

import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;
import engine.rendering.Drawer;
import engine.rendering.drawables.Drawable;
import engine.rendering.drawables.Layers;
import engine.rendering.drawables.Quad;
import minesweeper.Constants.kTile;;

public class Tile implements Drawable{
    public Quad outline;
    public Quad inner;

    public int x;
    public int y;
    public float l;

    public boolean isHidden;
    public boolean isBomb;
    public int count;

    public int index;
    public Layers layer;

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
        init();
    }

    public void draw(GL2 gl){
        System.out.println("drawing tile");
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

    @Override
    public void init() {
        try{
            index = Drawer.Frame(Layers.MIDGROUND).add(this);
        }
        catch(LayerDoesNotExist | DrawableNotInitialized e){
            System.out.println(e);
        }
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        try{
            Drawer.Frame(Layers.MIDGROUND).add(this);
        }
        catch(LayerDoesNotExist | DrawableNotInitialized e){
            
        }
    }

    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }
}
