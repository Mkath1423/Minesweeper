package engine.rendering;

import java.util.Map;
import java.util.EnumMap;

import com.jogamp.opengl.GL2;

import engine.exeptions.DrawableNotInitialized;
import engine.exeptions.LayerDoesNotExist;
import engine.rendering.color.Color;
import engine.rendering.geometry.Quad;
import engine.resourse.Sprite;

public class Drawer{

    private static Map<LayerKeys, Layer> frame;
  
    public static Layer Frame(LayerKeys layer) throws LayerDoesNotExist, DrawableNotInitialized{
        if(frame.containsKey(layer)){
            return frame.get(layer);
        }
        throw new LayerDoesNotExist("layer '"+ layer + "' does not exist.");
    }

    static {
        frame = new EnumMap<LayerKeys, Layer>(LayerKeys.class);
        for (LayerKeys layer : LayerKeys.values()) {
            frame.put(layer, new Layer());
        }
    }

    public static void addLayer(LayerKeys layer){
        frame.put(layer, new Layer());
    }

    public static void drawQuad(Quad q, Color c, GL2 gl){
        gl.glBegin(GL2.GL_QUADS);

        gl.glColor4f(c.r, c.g, c.b, c.a);

        gl.glVertex2f(q.left_top.x,     q.left_top.y);
        gl.glVertex2f(q.left_bottom.x,  q.left_bottom.y);
        gl.glVertex2f(q.right_bottom.x, q.right_bottom.y);
        gl.glVertex2f(q.right_top.x,    q.right_top.y);

        gl.glEnd();
        gl.glFlush();
    }

    public static void drawQuad(Quad q, Sprite s, GL2 gl){

        if(q == null || s == null || gl == null){
            // System.out.println("Null parameter in Drawer.drawQuad");
            return;
        }

        
        gl.glBindTexture(GL2.GL_TEXTURE_2D, s.texture.getTextureObject());
        
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(s.slice.left_top.x,     s.slice.left_top.y);
            gl.glVertex2f(q.left_top.x,             q.left_top.y);

            
            gl.glTexCoord2f(s.slice.left_bottom.x,  s.slice.left_bottom.y);
            gl.glVertex2f(q.left_bottom.x,          q.left_bottom.y);

            
            gl.glTexCoord2f(s.slice.right_bottom.x, s.slice.right_bottom.y);
            gl.glVertex2f(q.right_bottom.x,         q.right_bottom.y);

            
            gl.glTexCoord2f(s.slice.right_top.x,    s.slice.right_top.y);
            gl.glVertex2f(q.right_top.x,            q.right_top.y);
        gl.glEnd();

        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0); // clear the texture buffer
        gl.glFlush();
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
