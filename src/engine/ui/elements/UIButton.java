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
import engine.resource.SpriteMap;

/**
 * A UI button element
 * 
 * A button with an event that gets raised on click
 * Sprite switching for pressed, hovering and default
 */
public class UIButton<ReturnType> extends GameObject{
    
    public Transform transform;
    public Image image;

    // Sprites
    private SpriteMap mouseHoveringImage;
    private SpriteMap mousePressedImage;
    private SpriteMap defaultImage;

    private boolean buttonPressed = false;

    public Event<ReturnType> event;
    public ReturnType returnData;

    /**
     * Constructs a UIButton
     * 
     * @param data The data to be returned by the event
     * @param t    The transform
     * @param hovering Sprite for when the mouse is hovering
     * @param pressed Sprite for when the button is pressed down
     * @param other default sprite
     */
    public UIButton(ReturnType data, Transform t, SpriteMap hovering, SpriteMap pressed, SpriteMap other){
        event = new Event<ReturnType>();

        mouseHoveringImage = hovering;
        mousePressedImage  = pressed;
        defaultImage       = other;

        transform = t;
        image = new Image(defaultImage, 0, LayerKeys.UI, transform);
    
        returnData = data;

        MouseInput.register(MouseInputKeys.PRESSED,    (e) -> {if(isActive) this.OnMousePressed(e);});
        MouseInput.register(MouseInputKeys.RELEASED,   (e) -> {if(isActive) this.OnMouseReleased(e);});
        MouseInput.register(MouseInputKeys.MOUSEMOVED, (e) -> {if(isActive) this.OnMouseMoved(e);});
    }

    @Override
    public void Start(){
        image.Start();
    }


    @Override
    public void End(){
        image.End();
    }

    /**
     * Called when the mouse is pressed
     * 
     * Switches to pressed state 
     * 
     * @param e the mouse event
     */
    public void OnMousePressed(MouseEvent e){
        if(Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            image.spriteMap = mousePressedImage;
            buttonPressed = true;
        }
    }

    /**
     * Called when the mouse is released
     * 
     * Switches to default state
     * Invokes the event if the mouse is on the button 
     * 
     * @param e the mouse event
     */
    public void OnMouseReleased(MouseEvent e){
        if(buttonPressed && Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            event.invoke(returnData);
        }

        image.spriteMap = defaultImage;
        buttonPressed = false;
    }

    /**
     * Called when the mouse is moved
     * 
     * Switches to the hovering state if the mouse is above the button
     * 
     * @param e the mouse event
     */
    public void OnMouseMoved(MouseEvent e){
        if(!buttonPressed && Collisions.RectPoint(transform.getQuad(), new Point(e.getX(), e.getY()))){
            image.spriteMap = mouseHoveringImage;
        }
        else{
            image.spriteMap = defaultImage;
        }
    }
}
