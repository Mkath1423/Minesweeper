import javax.swing.JFrame;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import javax.media.opengl.awt.GLCanavas

public class Renderer
{
    private static GLWindow window;

        public static void init(){
            GLProfile.initSingleton();
            GLProfile profile = GLProfile.get(GLProfile.GL4);
            GLCapabilities caps = new GLCapabilities(profile);
            
      

            GlCanvas canvas = new GLCanavas(caps);
            Frame frame = new Frame();
            frame.add(canvas);
            
        }    

        public static void main(String[] args){
            System.out.println("main");
            init();
        }
}
