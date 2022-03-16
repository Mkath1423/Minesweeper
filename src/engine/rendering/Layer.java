package engine.rendering;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import engine.rendering.geometry.Quad;
import engine.resourse.Sprite;

public class Layer {

    public List<Drawable> layer;

    public Layer(){
        layer = new ArrayList<Drawable>();
    }

    public void add(Drawable d){
        // called by drawables to append themselves to the layer
        d.init();
        System.out.println("added thing");
        layer.add(d);
    }

    public void dispose(GLAutoDrawable gl){
        
    }

    public void remove(Drawable d){
        // called by drawables to remove themselves to the layer
        layer.remove(d);
    }

    public void draw(GL2 gl){
        Map<Sprite, List<Quad>> toDraw = new HashMap<>();

        // only called by the rendering engine
        //  draws the drawable to the gl frame
        for(Drawable d : layer){
            Sprite s = d.GetSprite();
            Quad q = d.GetQuad();

            if(!toDraw.containsKey(s)){
                toDraw.put(s, new ArrayList<Quad>());
            }
            toDraw.get(s).add(q);
        }

        for (Entry<Sprite, List<Quad>> e : toDraw.entrySet()) {
            Drawer.drawQuads(e.getValue(), e.getKey(), gl);
        }
    }

}
