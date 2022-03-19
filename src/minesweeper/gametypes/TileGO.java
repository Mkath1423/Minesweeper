package minesweeper.gametypes;


import com.jogamp.newt.event.MouseEvent;

import engine.Inputs.MouseInput;
import engine.Inputs.MouseInputKeys;
import engine.components.GameObject;
import engine.components.Image;
import engine.components.Transform;
import engine.components.Transform.PositionMode;
import engine.physics2D.collisions.Collisions;
import engine.physics2D.collisions.Vector2;
import engine.rendering.LayerKeys;
import engine.rendering.geometry.Point;
import engine.resourse.ImageResource;
import minesweeper.Constants.kTile;

public class TileGO extends GameObject{
    
    private Transform transform;

    private Image image;

    public boolean isBomb;
    public boolean isHidden;
    public boolean isFlagged;

    public int count;
    
    public TileGO(Vector2 position){
        transform = new Transform(position, 0f, new Vector2(kTile.length, kTile.length), PositionMode.LEFT_TOP);

        image     = new Image(ImageResource.getSpriteMap("2000.png"), 0, LayerKeys.MIDGROUND, transform);
        MouseInput.register(MouseInputKeys.CLICKED, (e) -> {if(isActive) this.onMouseClicked(e);});

        isBomb = false;
        isHidden = true;
        isFlagged = false;

    }

    @Override
    public void Start() {
        image.Start();

        image.spriteIndex = 0; 
    }

    public void onMouseClicked(MouseEvent e){
        if(Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            //System.out.printf("%s received %s\n", index, e.getButton());
            if(e.getButton() == 3 && isHidden){
                isFlagged = !isFlagged;

                image.spriteIndex = (isFlagged && isHidden) ? 2 : 0;
            }
            else if(e.getButton() == 1 && !isFlagged){
                isHidden =  false;

                if(isBomb)          image.spriteIndex = kTile.BOMB_CLICKED;
                else if(count == 0) image.spriteIndex = kTile.EMPTY;
                else                image.spriteIndex = kTile.COUNT_IMAGES[count];
            }
        }
    } 

    @Override
    public void End(){
        image.End();
    }

}
