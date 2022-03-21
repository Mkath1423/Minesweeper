package engine.components;

import engine.physics2D.collisions.Vector2;
import engine.rendering.geometry.Quad;

/** 
 * A positional component
 * 
 * specifies the position, rotation and scale of a GO
 * 
 * @warning currently does not use rotation
 * // TODO: make this use rotation
 * 
 * @author Lex Stapleton
*/
public class Transform {

    // Where the position of the position vector refers to
    // i.e. Top left point of the GO
    public static enum PositionMode {
        LEFT_TOP,
        MIDDLE_TOP,
        RIGHT_TOP,
    
        LEFT_CENTER,
        MIDDLE_CENTER,
        RIGHT_CENTER,
    
        LEFT_BOTTOM,
        MIDDLE_BOTTOM,
        RIGHT_BOTTOM
    }


    public Vector2 position;
    public float rotation;
    public Vector2 scale;

    public PositionMode positionMode;

    // Constructors

    /**
     * Constructs a transform
     * 
     * @param position the 2D position of the GO  
     * @param rotation the rotation of the GO (not used)
     * @param scale the 2D size of the game object
     * @param positionMode what point one the GO's rect is the given position?
     */
    public Transform(Vector2 position, float rotation, Vector2 scale, PositionMode positionMode){
        this.position = position;
        this.rotation = rotation;
        this.scale    = scale;
        this.positionMode = positionMode;

        CalculateTruePosition();
    }

    /**
     * Constructs a transform
     * 
     * defaults all values
     */
    public Transform(){
        this(new Vector2(0, 0),
                 0f,
             new Vector2(1, 1),
                 PositionMode.LEFT_TOP);
    }

    /**
     * Constructs a transform
     * 
     * defaults all other values
     * 
     * @param position the 2D position of the GO  
     */
    public Transform(Vector2 position){
        this(    position,
                 0f,
             new Vector2(1, 1),
                 PositionMode.LEFT_TOP);
    }

    /**
     * Constructs a transform
     * 
     * defaults all other values
     * 
     * @param position the 2D position of the GO 
     * @param rotation the rotation of the GO (not used) 
     */
    public Transform(Vector2 position, float rotation){
        this(    position,
                 rotation,
             new Vector2(1, 1),
                 PositionMode.LEFT_TOP);
    }

    /**
     * Converts the position to TOP_LEFT
     * 
     * Call this only once in the constructor 
     * 
     * if the position mode is in the center of a dim
     *      subtract half the quad size in that dim
     * 
     * if the position mode is at the end of a dim
     *      subtract the quad size in that dim
     * 
     * 
     */
    private void CalculateTruePosition(){
        switch(positionMode){
            case LEFT_TOP:
                break;

            case LEFT_CENTER:
                position.y -= scale.y / 2;
                break;
        
            case LEFT_BOTTOM:
                position.y -= scale.y;
                break;
    
            case MIDDLE_TOP:
                position.x -= scale.x / 2;
                break;
    
            case MIDDLE_CENTER:
                position.x -= scale.x / 2;
                position.y -= scale.y / 2;
                break;
    
            case MIDDLE_BOTTOM:
                position.x -= scale.x / 2;
                position.y -= scale.y;
                break;
    
            case RIGHT_TOP:
                position.x -= scale.x;
                break;
    
            case RIGHT_CENTER:
                position.x -= scale.x;
                position.y -= scale.y / 2;
                break;
    
            case RIGHT_BOTTOM:
                position.x -= scale.x;
                position.y -= scale.y;
                break;
        }
    }

    
    /** 
     * Generates a Quad object
     * 
     * Makes a rectangle with the position of the object and its scale
     * 
     * @return Quad
     */
    public Quad getQuad(){
        return Quad.Rectangle(position.x, position.y, scale.x, scale.y);
    }
}
