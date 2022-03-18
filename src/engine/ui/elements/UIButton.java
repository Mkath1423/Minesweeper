package engine.ui.elements;


import com.jogamp.newt.event.MouseEvent;

import engine.Inputs.MouseInput;
import engine.Inputs.MouseInputKeys;

import engine.components.Event;
import engine.components.GameObject;
import engine.components.Image;
import engine.components.Transform;

import engine.physics2D.collisions.Collisions;

import engine.rendering.LayerKeys;
import engine.rendering.geometry.Point;
import engine.resourse.SpriteMap;

public class UIButton<ReturnType> extends GameObject{
    
    public Transform transform;
    public Image image;

    private SpriteMap mouseHoveringImage;
    private SpriteMap mousePressedImage;
    private SpriteMap defaultImage;

    private boolean buttonPressed = false;

    public Event<ReturnType> event;
    public ReturnType returnData;

    public UIButton(ReturnType data, Transform t, SpriteMap hovering, SpriteMap pressed, SpriteMap other){
        event = new Event<ReturnType>();

        mouseHoveringImage = hovering;
        mousePressedImage  = pressed;
        defaultImage       = other;

        transform = t;
        image = new Image(defaultImage, 0, LayerKeys.UI, transform);
    
        MouseInput.register(MouseInputKeys.PRESSED,    this::OnMousePressed);
        MouseInput.register(MouseInputKeys.PRESSED,    this::OnMouseReleased);
        MouseInput.register(MouseInputKeys.MOUSEMOVED, this::OnMouseMoved);
    }

    public void OnMousePressed(MouseEvent e){
        if(Collisions.QuadPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            image.spriteMap = mousePressedImage;
            buttonPressed = true;
        }
    }

    public void OnMouseReleased(MouseEvent e){
        if(buttonPressed && Collisions.QuadPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            event.invoke(returnData);
        }

        image.spriteMap = defaultImage;
        buttonPressed = false;
    }

    public void OnMouseMoved(MouseEvent e){
        if(!buttonPressed && Collisions.QuadPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            image.spriteMap = mouseHoveringImage;
        }
        else{
            image.spriteMap = defaultImage;
        }
    }
}
