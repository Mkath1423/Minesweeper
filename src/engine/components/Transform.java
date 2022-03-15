package engine.components;

import engine.physics2D.collisions.Vector2;

public class Transform {
    public Vector2 position;
    public float rotation;

    public PositionMode positionMode;

    public Transform(){
        this.position = new Vector2(0, 0);
        this.rotation = 0f;
        this.positionMode = PositionMode.LEFT_TOP;
    }

    public Transform(Vector2 position){
        this.position = position;
        this.rotation = 0f;
        this.positionMode = PositionMode.LEFT_TOP;
    }

    public Transform(Vector2 position, float rotation){
        this.position = position;
        this.rotation = rotation;
        this.positionMode = PositionMode.LEFT_TOP;
    }

    public Transform(Vector2 position, float rotation, PositionMode positionMode){
        this.position = position;
        this.rotation = rotation;
        this.positionMode = positionMode;
    }
}
