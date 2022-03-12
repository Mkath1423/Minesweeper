package minesweeper.gametypes;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.opengl.GL2;

import engine.Inputs.KeyInput;
import engine.Inputs.KeyInputKeys;
import engine.Inputs.MouseInput;
import engine.Inputs.MouseInputKeys;
import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;
import engine.physics2D.collisions.Collisions;
import engine.rendering.Drawable;
import engine.rendering.Drawer;
import engine.rendering.LayerKeys;
import engine.rendering.geometry.Point;
import engine.rendering.geometry.Quad;
import engine.resourse.ImageResource;
import minesweeper.Constants.kTile;;

public class Tile implements Drawable {
    public Quad outline;
    public Quad inner;

    public float x;
    public float y;
    public float l;

    public boolean isHidden;
    public boolean isBomb;
    public boolean isFlagged;
    public int count;

    public int index;
    public LayerKeys layer;

    public Tile(float _x, float _y, float _l){
        x = _x;
        y = _y;
        l = _l;

        isHidden = true;
        isBomb = false;
        isFlagged = false;
        count = 0;

        outline = Quad.Square(x, y, l);
        inner   = Quad.Square(x + l * (1 - kTile.boarderPercent) / 2, 
                              y + l * (1 - kTile.boarderPercent) / 2, 
                              l * kTile.boarderPercent);

        MouseInput.register(MouseInputKeys.CLICKED, this::onMouseClicked);

        init();
    }

    public Tile(Point point, float l) {
        this(point.x, point.y, l);
    }

    public void draw(GL2 gl){
        if(isFlagged){
            // flag sprite
            Drawer.drawQuad(outline, ImageResource.getSprite("2000.png", 2), gl);
        }
        else if(isHidden){
            // hidden sprite
            Drawer.drawQuad(outline, ImageResource.getSprite("2000.png", 0), gl);
        }
        else if(!isHidden && isBomb){
            // bomb sprite
            Drawer.drawQuad(outline, ImageResource.getSprite("2000.png", 6), gl);
        }
        else if(!isHidden && !isBomb && count == 0){
            // empty sprite
            Drawer.drawQuad(outline, ImageResource.getSprite("2000.png", 1), gl);
        }
        else if(!isHidden && !isBomb){
            // number sprite
            Drawer.drawQuad(outline, ImageResource.getSprite("2000.png", 7 + count), gl);
        }
    }

    public void onMouseClicked(MouseEvent e){
        if(index == 0){
            System.out.println(outline);
            System.out.printf("Point(%s, %s)\n", e.getX(), e.getY());
        }
        if(Collisions.Square_Point(outline, new Point(e.getX(), e.getY()))){
            System.out.printf("%s recived %s\n", index, e.getButton());
            if(e.getButton() == 3 && isHidden){
                isFlagged = !isFlagged;
            }
            else if(e.getButton() == 1 && !isFlagged){
                isHidden =  false;
            }
        }
    }

    @Override
    public void init() {
        try{
            index = Drawer.Frame(LayerKeys.MIDGROUND).add(this);
        }
        catch(LayerDoesNotExist | DrawableNotInitialized e){
            System.out.println(e);
        }
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        try{
            Drawer.Frame(LayerKeys.MIDGROUND).add(this);
        }
        catch(LayerDoesNotExist | DrawableNotInitialized e){
            
        }
    }

    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }
}
