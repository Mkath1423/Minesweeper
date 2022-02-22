import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL2;

import engine.drawables.Drawable;

public class Layer {

    public List<Drawable> layer;

    public Layer(){
        layer = new ArrayList<Drawable>();
    }

    public int add(Drawable d){
        // called by drawables to append themselves to the layer
        layer.add(d);
        return layer.size() - 1;
    }

    public void remove(int i){
        // called by drawables to remove themselves to the layer
        layer.remove(i);
    }

    public void draw(GL2 gl){
        // only called my the rendering engine
        //  draws the drawable to the gl frame
        for(Drawable d : layer){
            d.draw(gl);
        }
    }

}
