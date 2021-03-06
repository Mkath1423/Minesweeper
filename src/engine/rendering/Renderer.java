package engine.rendering;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

import com.jogamp.opengl.util.FPSAnimator;

import engine.EventListener;
import engine.Inputs.KeyInputCaller;
import engine.Inputs.MouseInputCaller;
import minesweeper.Game;

public class Renderer
{
    private static GLWindow window = null;

    private static GLProfile profile = null;

    public static void init(){
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        
        window = GLWindow.create(caps);
        window.setSize(640, 320);
        window.setRealized(false);
        window.addGLEventListener(new EventListener(new Game()));
        window.addMouseListener(new MouseInputCaller());
        window.addKeyListener(new KeyInputCaller());
        

        FPSAnimator animator = new FPSAnimator(window, 130);
        animator.start();
   
        window.setVisible(true);
    }

    public static GLProfile getProfile(){
        return profile;
    }
}
