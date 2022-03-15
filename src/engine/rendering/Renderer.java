package engine.rendering;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLContext;
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
        profile = GLProfile.get(GLProfile.GL4);
        GLCapabilities caps = new GLCapabilities(profile);
        
        window = GLWindow.create(caps);

        window.setTitle("JOGL Game Engine");
        window.setSize(640, 320);

        window.setContextCreationFlags(GLContext.CTX_OPTION_DEBUG);
        window.setVisible(true);

        window.addGLEventListener(new EventListener(new Game()));
        window.addMouseListener(new MouseInputCaller());
        window.addKeyListener(new KeyInputCaller());
        

        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();
   
        window.setVisible(true);

        // https://github.com/jvm-graphics-labs/hello-triangle/blob/master/src/main/java/gl4/HelloTriangleSimple.java
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyed(WindowEvent e) {
                animator.stop();
                System.exit(1);
            }
        });
    }

    public static GLProfile getProfile(){
        return profile;
    }
}
