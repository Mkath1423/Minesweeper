package engine.rendering;

import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import engine.drawables.Layers;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;

public final class Drawer implements GLEventListener{

    private Map<Integer, Layer> frame;
  
    public Drawer(){
        // TODO: fix this
        frame = new HashMap<Integer, Layer>();
        for (Layers layer_num : Layers.values()) {
            frame.put(0, new Layer());
        }
    }

    public void clearFrame(){

    }

    public void draw(GL2 gl){
        
    }

    public void addLayer(int layer){
        frame.put(layer, new Layer());
    }

    public Layer Frame(int layer) throws LayerDoesNotExist, DrawableNotInitialized{
        if(frame.containsKey(layer)){
            frame.get(layer);

        }
        throw new LayerDoesNotExist("layer '"+ "layer" + "' does not exist.");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        for(Map.Entry<Integer, Layer> entry : frame.entrySet()){
            entry.getValue().draw(gl);
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        System.out.println("dispose");
        
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // TODO we cant reshape lol
        
    }

}
