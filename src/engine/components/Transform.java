package engine.components;

import engine.physics2D.collisions.Vector2;
import engine.rendering.geometry.Quad;

public class Transform {

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

    public Transform(Vector2 position, float rotation, Vector2 scale, PositionMode positionMode){
        this.position = position;
        this.rotation = rotation;
        this.scale    = scale;
        this.positionMode = positionMode;
    }

    public Transform(){
        this(new Vector2(0, 0),
                 0f,
             new Vector2(1, 2),
                 PositionMode.LEFT_TOP);
    }

    public Transform(Vector2 position){
        this(    position,
                 0f,
             new Vector2(1, 1),
                 PositionMode.LEFT_TOP);
    }

    public Transform(Vector2 position, float rotation){
        this(    position,
                 rotation,
             new Vector2(1, 1),
                 PositionMode.LEFT_TOP);
    }



    // Methods

    public Quad getQuad(){
        Vector2 transformedPosition = position;

        switch(positionMode){
            case LEFT_TOP:
                break;

            case LEFT_CENTER:
                transformedPosition.y -= scale.y / 2;
                break;
        
            case LEFT_BOTTOM:
                transformedPosition.y -= scale.y;
                break;
    
            case MIDDLE_TOP:
                transformedPosition.x -= scale.x / 2;
                break;
    
            case MIDDLE_CENTER:
                transformedPosition.x -= scale.x / 2;
                transformedPosition.y -= scale.y / 2;
                break;
    
            case MIDDLE_BOTTOM:
                transformedPosition.x -= scale.x / 2;
                transformedPosition.y -= scale.y;
                break;
    
            case RIGHT_TOP:
                transformedPosition.x -= scale.x;
                break;
    
            case RIGHT_CENTER:
                transformedPosition.x -= scale.x;
                transformedPosition.y -= scale.y / 2;
                break;
    
            case RIGHT_BOTTOM:
                transformedPosition.x -= scale.x;
                transformedPosition.y -= scale.y;
                break;
        }

        return Quad.Rectangle(transformedPosition.x, transformedPosition.y, scale.x, scale.y);
    }
}
