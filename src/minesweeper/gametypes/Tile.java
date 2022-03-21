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
import engine.resource.ImageResource;
import minesweeper.Constants.kTile;

public class Tile extends GameObject{
    
    // components
    private Transform transform;
    private Image image;

    // Events for when things happen to the tile
    //    Game Scene uses these for end states and stats
    public Event<Boolean> onTileRevealed;
    public Event<Boolean> onTileFlagged;
    public Event<Boolean> onTileUnflagged;

    // State of the tile
    public boolean isBomb;
    public boolean isHidden;
    public boolean isFlagged;
    public boolean gameIsOver;

    public int count; // Number of bombs
    

    /**
     * Constructs a minesweeper tile
     * 
     * @param position the top left corner of the tile
     */
    public Tile(Vector2 position){

        // Initialize components
        transform = new Transform(position, 0f, new Vector2(kTile.length, kTile.length), PositionMode.LEFT_TOP);
        image = new Image(ImageResource.getSpriteMap("2000.png"), 0, LayerKeys.MIDGROUND, transform);


        // Initialize Events
        //   Listeners from GameScene will append themselves
        onTileRevealed  = new Event<Boolean>();
        onTileFlagged   = new Event<Boolean>();
        onTileUnflagged = new Event<Boolean>();

        // Initialize state of the tile
        isBomb = false;
        isHidden = true;
        isFlagged = false;
        gameIsOver = true;

        // Add mouse released callback
        //   Released instead of clicked allows for slow clicks
        MouseInput.register(MouseInputKeys.RELEASED, (e) -> {this.OnMouseClicked(e);});
    }

    @Override
    public void Start() {
        image.Start();

        // reset the state
        image.spriteIndex = 0; 
        isFlagged = false;
        isHidden = true;
    }

    /**
     * Called when the mouse is clicked
     * 
     * Switches the tile to default, flagged and revealed states 
     * Invokes events as necessary
     * 
     * @param e the MouseEvent object containing info about the event
     */
    public void OnMouseClicked(MouseEvent e){

        // dont run this when the player loses or when not in the game scene
        if(!isActive || gameIsOver) return;

        // check if the mouse click on this object
        if(Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            
            // if the player wants to flag this tile and the tile is not revealed
            if(e.getButton() == 3 && isHidden){
                // toggle isFlagged and trigger corresponding event
                if(isFlagged){
                    isFlagged = false;
                    onTileUnflagged.invoke(isBomb);
                } 
                else{
                    isFlagged = true;
                    onTileFlagged.invoke(isBomb);
                }

                // toggle between flagged and hidden sprites
                image.spriteIndex = (isFlagged && isHidden) ? kTile.FLAGGED : kTile.UNCHECKED;
            }

            // is the player wants to reveal this tile and it is not flagged
            else if(e.getButton() == 1 && !isFlagged){
                
                // reveal the tile and trigger the onTileRevealed event
                isHidden =  false;
                onTileRevealed.invoke(isBomb);

                // Change to the correct revealed sprite
                if(isBomb)          image.spriteIndex = kTile.BOMB_CLICKED;
                else if(count == 0) image.spriteIndex = kTile.EMPTY;
                else                image.spriteIndex = kTile.COUNT_IMAGES[Math.min(count, 8)];
            }
        }
    } 

    /**
     * Changes image sprite to the correct revealed sprite at the end of the game
     * 
     * Called when a bomb is revealed or when the player finds all bombs
     * 
     * TODO: call this when the player finds all bombs
     *
     */
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
