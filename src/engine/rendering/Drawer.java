package engine.rendering;

import java.util.Dictionary;
import java.util.Map;

import com.jogamp.opengl.GL2;

import engine.exeptions.LayerDoesNotExist;
import jogamp.graph.font.typecast.ot.table.CffTable.Dict;

public final class Drawer {

    private Map<String, Layer> frame;

    public static void DrawSquare(){

    }
    
    public void clearFrame(){

    }

    public void draw(GL2 gl){
        
    }

    public void addLayer(String layer){
        frame.put(layer, new Layer());
    }

    public Layer Frame(String layer) throws LayerDoesNotExist{
        if(frame.containsKey(layer)){
            frame.get(layer);

        }
        throw new LayerDoesNotExist("layer '"+ "layer" + "' does not exist.");
    }

}
