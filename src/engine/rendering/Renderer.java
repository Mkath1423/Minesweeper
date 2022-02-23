package engine.rendering;

import javax.swing.JFrame;

import java.awt.Frame;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import minesweeper.EventListener;

public class Renderer
{
    private static GLWindow window = null;

    public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        
        window = GLWindow.create(caps);
        window.setSize(640, 320);
        window.setRealized(false);
        window.addGLEventListener(new EventListener());

        

        FPSAnimator animator = new FPSAnimator(window, 130);
        animator.start();
   
        window.setVisible(true);
        
    }
}
