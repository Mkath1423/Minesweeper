package engine.rendering;

import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;

public class Drawer{

    private static Map<LayerKeys, Layer> frame;
  
    public static Layer Frame(LayerKeys layer) throws LayerDoesNotExist, DrawableNotInitialized{
        if(frame.containsKey(layer)){
            return frame.get(layer);
        }
        throw new LayerDoesNotExist("layer '"+ layer + "' does not exist.");
    }

    public static void init(){
        frame = new EnumMap<LayerKeys, Layer>(LayerKeys.class);
        for (LayerKeys layer : LayerKeys.values()) {
            frame.put(layer, new Layer());
        }
    }

    public static void addLayer(LayerKeys layer){
        frame.put(layer, new Layer());
    }

    public static void draw(GL2 gl){
        for(Map.Entry<LayerKeys, Layer> entry : frame.entrySet()){
            entry.getValue().draw(gl);
        }
    }

    public static void clearFrame(){
        // TODO: Implement this
    }

    public static void dispose(){
        // TODO: Implement this
    }

    public static void reshape(){
        // TODO: Implement this
    }







}
