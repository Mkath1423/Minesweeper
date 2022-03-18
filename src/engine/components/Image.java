package engine.components;

import engine.rendering.LayerKeys;
import engine.rendering.color.Color;
import engine.rendering.geometry.Quad;

import engine.exeptions.LayerDoesNotExist;
import engine.rendering.Drawable;
import engine.rendering.Drawer;
import engine.resourse.ImageResource;
import engine.resourse.Sprite;
import engine.resourse.SpriteMap;

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

    public Image(SpriteMap _spriteMap, int _spriteIndex, LayerKeys _layer, Transform _transform){
        this(_spriteMap, _spriteIndex, _layer, _transform, false);
    }

    public Image(SpriteMap _spriteMap, int _spriteIndex, LayerKeys _layerKeys, Transform _transform, boolean _isFixed){
        this.spriteMap   = _spriteMap;
        this.spriteIndex = _spriteIndex;
        this.layer       = _layerKeys;
        this.transform   = _transform;
        this.isFixed     = _isFixed;

        if(isFixed){
            this.boundingBox = transform.getQuad();
        }

        try {
            Drawer.Frame(layer).add(this);
        } catch (LayerDoesNotExist e) {
            System.out.println("Image could not be initialized. LayerDoesNotExist.");
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
    }

    @Override
    public void dispose() {
        try {
            Drawer.Frame(layer).remove(this);
        } catch (LayerDoesNotExist e) {
            System.out.println("Could not remove drawable: " + e.toString());
        }
    }

    @Override
    public Sprite GetSprite() {
        return spriteMap.getSprite(spriteIndex);
    }

    @Override
    public Quad GetQuad() {
        if(isFixed) return boundingBox;
        return transform.getQuad();
    }

    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }


}
