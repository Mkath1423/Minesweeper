package engine.rendering;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
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

    private static FPSAnimator animator = null;

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
        

        animator = new FPSAnimator(window, 130);
        animator.start();
   
        window.setVisible(true);

        // https://github.com/jvm-graphics-labs/hello-triangle/blob/master/src/main/java/gl4/HelloTriangleSimple.java
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyed(WindowEvent e) {
                ExitProgram();
            }
        });
        
    }

    public static void ExitProgram(){
        animator.stop();
        System.exit(1);
    }

    public static GLProfile getProfile(){
        return profile;
    }
}
