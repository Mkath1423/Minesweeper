package engine.components;

import engine.rendering.LayerKeys;
import engine.rendering.geometry.Quad;
import engine.resourse.Sprite;
import engine.resourse.SpriteMap;

public class Image {
    public SpriteMap spriteMap;
    public int spriteIndex;

    public LayerKeys layer;

    public Transform transform;

    public boolean isFixed;
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
    }


}
