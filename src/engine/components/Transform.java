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

        CalculateTruePosition();
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

    // Methods

    public Quad getQuad(){
        return Quad.Rectangle(position.x, position.y, scale.x, scale.y);
    }
}
