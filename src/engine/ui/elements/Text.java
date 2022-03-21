package engine.ui.elements;

import engine.components.GameObject;
import engine.components.Transform;
import engine.rendering.Drawable;
import engine.rendering.geometry.Quad;
import engine.resource.Sprite;
import engine.resource.SpriteMap;

// TODO: make this into something

public class Text extends GameObject implements Drawable{

    public String text = "";

    public Transform transform;

    public SpriteMap font;

    // !! IMPORTANT !! IGNORE THIS FILE !!
    public Text(Transform transform, SpriteMap font, String text){
        this.transform = transform;
        this.font      = font;
        this.text      = text;
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Sprite GetSprite() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Quad GetQuad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void reshape(int x, int y, int w, int h) {
        // TODO Auto-generated method stub
        
    }
    
}
