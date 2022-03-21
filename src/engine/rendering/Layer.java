package engine.rendering;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import engine.rendering.geometry.Quad;
import engine.resource.Sprite;

public class Layer {

    public List<Drawable> layer;

    // Constructs an empty Layer
    public Layer(){
        layer = new ArrayList<Drawable>();
    }

    /**
     * Add a drawable to the list of drawables
     * 
     * calls the init() method for the drawable to initialize it's self before rendering (marked for removal)
     * 
     * @param d the drawable to add
     */
    public void add(Drawable d){
        d.init();
        layer.add(d);
    }

    /**
     * Called when the gl window closes
     * 
     * @param gl the gl context
     */
    public void dispose(GLAutoDrawable gl){
        
    }

    /**
     * Remove a drawable from the list of drawables
     * 
     * @param d the drawable to add
     */
    public void remove(Drawable d){
        layer.remove(d);
    }

    /**
     * Draws all drawables in the layer
     * 
     * only called by the rendering engine
     * draws the drawable to the gl context
     * 
     * Sorts drawables by texture
     * this allows each texture to be set only once
     * 
     * @param gl the gl context
     */
    public void draw(GL2 gl){
        // Sprites and Quads that use that sprite
        Map<Sprite, List<Quad>> toDraw = new HashMap<>();

        
        for(Drawable d : layer){
            // get sprite and quad for each drawable
            Sprite s = d.GetSprite();
            Quad q = d.GetQuad();

            // organizes quads by the sprite they use
            if(!toDraw.containsKey(s)){
                toDraw.put(s, new ArrayList<Quad>());
            }
            toDraw.get(s).add(q);
        }

        // Draw each list of quads with their sprite
        for (Entry<Sprite, List<Quad>> e : toDraw.entrySet()) {
            Drawer.drawQuads(e.getValue(), e.getKey(), gl);
        }
    }
}
