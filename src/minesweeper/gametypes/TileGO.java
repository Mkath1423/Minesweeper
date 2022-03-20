package minesweeper.gametypes;


import com.jogamp.newt.event.MouseEvent;

import engine.Inputs.MouseInput;
import engine.Inputs.MouseInputKeys;
import engine.components.Event;
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

    public Event<Boolean> onTileRevealed;
    public Event<Boolean> onTileFlagged;
    public Event<Boolean> onTileUnflagged;

    public boolean isBomb;
    public boolean isHidden;
    public boolean isFlagged;
    public boolean gameIsOver;

    public int count;
    
    public TileGO(Vector2 position){
        transform = new Transform(position, 0f, new Vector2(kTile.length, kTile.length), PositionMode.LEFT_TOP);

        image     = new Image(ImageResource.getSpriteMap("2000.png"), 0, LayerKeys.MIDGROUND, transform);
        MouseInput.register(MouseInputKeys.RELEASED, (e) -> {if(isActive) this.onMouseClicked(e);});

        isBomb = false;
        isHidden = true;
        isFlagged = false;
        gameIsOver = true;

        onTileRevealed  = new Event<Boolean>();
        onTileFlagged   = new Event<Boolean>();
        onTileUnflagged = new Event<Boolean>();
    }

    @Override
    public void Start() {
        image.Start();

        image.spriteIndex = 0; 
        isFlagged = false;
        isHidden = true;
    }

    public void onMouseClicked(MouseEvent e){
        if(!isActive || gameIsOver) return;

        if(Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            
            System.out.println("mouseClicked");
            //System.out.printf("%s received %s\n", index, e.getButton());
            if(e.getButton() == 3 && isHidden){
                if(isFlagged){
                    isFlagged = false;
                    onTileUnflagged.invoke(isBomb);
                } 
                else{
                    isFlagged = true;
                    onTileFlagged.invoke(isBomb);
                }

                image.spriteIndex = (isFlagged && isHidden) ? 2 : 0;
            }
            else if(e.getButton() == 1 && !isFlagged){
                isHidden =  false;

                onTileRevealed.invoke(isBomb);

                if(isBomb)          image.spriteIndex = kTile.BOMB_CLICKED;
                else if(count == 0) image.spriteIndex = kTile.EMPTY;
                else                image.spriteIndex = kTile.COUNT_IMAGES[Math.min(count, 8)];
            }
        }
    } 

    public void RevealTile(){
        if(isHidden && isFlagged && isBomb){
            image.spriteIndex = kTile.FLAGGED;
        }
        else if(isHidden && isFlagged && !isBomb){
            image.spriteIndex = kTile.NOT_BOMB;
        }
        else if(!isHidden && !isFlagged && isBomb){
            image.spriteIndex = kTile.BOMB_CLICKED;
        }
        else if(isHidden && !isFlagged && isBomb){
            image.spriteIndex = kTile.BOMB_NOT_FOUND;
        }
        else if(isHidden && !isFlagged && !isBomb){
            image.spriteIndex = kTile.COUNT_IMAGES[Math.min(count, 8)];
        }
    }

    @Override
    public void End(){
        image.End();
    }

}
