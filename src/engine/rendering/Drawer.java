package engine.rendering;

import java.util.Map;
import java.util.EnumMap;
import java.util.List;

import com.jogamp.opengl.GL2;

import engine.exeptions.LayerDoesNotExist;
import engine.rendering.color.Color;
import engine.rendering.geometry.Quad;
import engine.resourse.Sprite;

/**
 * A static drawer class
 * 
 * Draws every registered drawable in the correct order
 * 
 * 
 * 
 */
public class Drawer{

    private static Map<LayerKeys, Layer> frame;
  
    
    /** 
     * Getter for layers within frame
     * 
     * @param layer the layer value from the LayerKeys Enum
     * @return the layer
     * 
     * @throws LayerDoesNotExist thrown if the layer is not in the frame map
     */
    public static Layer Frame(LayerKeys layer) throws LayerDoesNotExist{
        if(frame.containsKey(layer)){
            return frame.get(layer);
        }
        throw new LayerDoesNotExist("layer '"+ layer + "' does not exist.");
    }

    /** 
     * Static initializer for the layers map
     * 
     * Creates an entry for each value in the LayerKeys enum
     */
    static {
        frame = new EnumMap<LayerKeys, Layer>(LayerKeys.class);
        for (LayerKeys layer : LayerKeys.values()) {
            frame.put(layer, new Layer());
        }
    }

  /** 
     * Invokes the draw method for all registered drawables
     * 
     * Layers are drawn in correct order for proper layering.
     * 
     * @param gl the gl window
     */
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

    // ------------------------- DRAWING METHODS ------------------------- // 
    
    /** 
     * Draws a quad to the gl window
     * 
     * @param q the quad
     * @param c the color
     * @param gl the gl context
     */
    public static void drawQuad(Quad q, GL2 gl){
        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex2f(q.left_top.x,     q.left_top.y);
        gl.glVertex2f(q.left_bottom.x,  q.left_bottom.y);
        gl.glVertex2f(q.right_bottom.x, q.right_bottom.y);
        gl.glVertex2f(q.right_top.x,    q.right_top.y);

        gl.glEnd();
    }

    /** 
     * Draws a list of quads to the gl window
     * 
     * @param qs a list of quads that all use the same sprite
     * @param s the sprite they all use
     * @param gl the gl context
     */
    public static void drawQuads(List<Quad> qs, Sprite s, GL2 gl){
        
        // return is any are null
        if(qs == null || s == null || gl == null) return;

        // bind the texture to draw on the quad
        gl.glBindTexture(GL2.GL_TEXTURE_2D, s.texture.getTextureObject());
        
        // Start drawing a quad
        gl.glBegin(GL2.GL_QUADS);

            // set texture coordinates
            


            // set the vertices of each quad
            for(Quad q : qs){
                gl.glTexCoord2f(s.slice.left_top.x,     s.slice.left_top.y);
                gl.glVertex2f(q.left_top.x,             q.left_top.y);
                gl.glTexCoord2f(s.slice.left_bottom.x,  s.slice.left_bottom.y);
                gl.glVertex2f(q.left_bottom.x,          q.left_bottom.y);
                gl.glTexCoord2f(s.slice.right_bottom.x, s.slice.right_bottom.y);
                gl.glVertex2f(q.right_bottom.x,         q.right_bottom.y);
                gl.glTexCoord2f(s.slice.right_top.x,    s.slice.right_top.y);
                gl.glVertex2f(q.right_top.x,            q.right_top.y);
            }           

        // Stop drawing quads
        gl.glEnd();

        // clear the texture buffer
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        gl.glFlush();
    }

    
    /** 
     * Draws a quad with a sprite to the gl context
     * 
     * @param q the quad
     * @param s the sprite
     * @param gl the gl context
     */
    public static void drawQuad(Quad q, Sprite s, GL2 gl){

        // return is any are null
        if(q == null || s == null || gl == null){
            // System.out.println("Null parameter in Drawer.drawQuad");
            return;
        }

        // bind the texture to draw on the quad
        gl.glBindTexture(GL2.GL_TEXTURE_2D, s.texture.getTextureObject());
        
        // Start drawing a quad
        gl.glBegin(GL2.GL_QUADS);

            // set the top left point of the quad and texture
            gl.glTexCoord2f(s.slice.left_top.x,     s.slice.left_top.y);
            gl.glVertex2f(q.left_top.x,             q.left_top.y);

            
            // set the bottom left point of the quad and texture
            gl.glTexCoord2f(s.slice.left_bottom.x,  s.slice.left_bottom.y);
            gl.glVertex2f(q.left_bottom.x,          q.left_bottom.y);

            
            // set the bottom right point of the quad and texture
            gl.glTexCoord2f(s.slice.right_bottom.x, s.slice.right_bottom.y);
            gl.glVertex2f(q.right_bottom.x,         q.right_bottom.y);

            
            // set the top right point of the quad and texture
            gl.glTexCoord2f(s.slice.right_top.x,    s.slice.right_top.y);
            gl.glVertex2f(q.right_top.x,            q.right_top.y);

        gl.glEnd();

        // clear the texture buffer
        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        gl.glFlush();
    }

    
  







}
