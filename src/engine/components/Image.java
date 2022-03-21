package engine.components;

import engine.rendering.LayerKeys;
import engine.rendering.color.Color;
import engine.rendering.geometry.Quad;
import engine.resource.Sprite;
import engine.resource.SpriteMap;
import engine.exeptions.LayerDoesNotExist;
import engine.rendering.Drawable;
import engine.rendering.Drawer;


/** 
 * A rendering component
 * 
 * Adds the ability for a GO to render a sprite to the screen
 * 
 * @author Lex Stapleton
*/
public class Image implements Drawable{
    public SpriteMap spriteMap;
    public int spriteIndex;

    public LayerKeys layer;

    public Color color;

    public Transform transform;

    public boolean isFixed;
    public boolean isSprite;
    public boolean isVisible;

    private Quad boundingBox;

    /**
     * Constructs the image
     * 
     * defaults isFixed to false
     * 
     * @param _spriteMap the sprite map to reference
     * @param _spriteIndex the index of the initial sprite
     * @param _layer the layer to draw to
     * @param _transform a reference to the transform
     */
    public Image(SpriteMap _spriteMap, int _spriteIndex, LayerKeys _layer, Transform _transform){
        this(_spriteMap, _spriteIndex, _layer, _transform, false);
    }

    /**
     * Constructs the image
     * 
     * @param _spriteMap the sprite map to reference
     * @param _spriteIndex the index of the initial sprite
     * @param _layer the layer to draw to
     * @param _transform a reference to the transform
     * @param _isFixed true if the image will not move (not currently used)
     */
    public Image(SpriteMap _spriteMap, int _spriteIndex, LayerKeys _layerKeys, Transform _transform, boolean _isFixed){
        this.spriteMap   = _spriteMap;
        this.spriteIndex = _spriteIndex;
        this.layer       = _layerKeys;
        this.transform   = _transform;
        this.isFixed     = _isFixed;

        if(isFixed){
            this.boundingBox = transform.getQuad();
        }
    }

    /**
     * Adds the image component to the corresponding layer on the drawer
     * 
     * @warning call this method in the start method of any GO using this component
     */
    public void Start(){
        try {
            Drawer.Frame(layer).add(this);
        } catch (LayerDoesNotExist e) {
            System.out.println("Image could not be initialized. LayerDoesNotExist.");
            e.printStackTrace();
        }
    }

    /**
     * Removes the image component to the corresponding layer on the drawer
     * 
     * @warning call this method in the end method of any GO using this component
     */
    public void End(){
        try {
            Drawer.Frame(layer).remove(this);
        } catch (LayerDoesNotExist e) {
            System.out.println("Image could not be removed. LayerDoesNotExist.");
            e.printStackTrace();
        }
    }


    /**
     * Initialize the drawable before adding to a layer
     *
     * Called by the Layer object
     */
    @Override
    public void init() {
    }
    
    /* * 
     * Returns the sprite object to the Layer
     * 
     * Used for sorting drawables by sprite and only each binding a sprite once
     * 
     * @return Sprite the texture and tex coordinates
     */ 
    @Override
    public Sprite GetSprite() {
        return spriteMap.getSprite(spriteIndex);
    }

    
    /** 
     * Returns the sprite object to the Layer
     * 
     * Used for sorting drawables by sprite and only each binding a sprite once
     * 
     * @return Quad the quad to be drawn
     */
    @Override
    public Quad GetQuad() {
        if(isFixed) return boundingBox;
        return transform.getQuad();
    }

    
    /** 
     * NOT USED
     * 
     * @param x
     * @param y
     * @param w
     * @param h
     */
    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }

}
