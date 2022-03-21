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
    // the window
    private static GLWindow window = null;

    // the profile of the gl context
    private static GLProfile profile = null;

    // runs program at specified fps
    private static FPSAnimator animator = null;

    // Initializes the renderer, call this in main
    public static void init(){
        // create the profile and caps
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        
        // create the window
        window = GLWindow.create(caps);
        window.setSize(640, 320);
        window.setRealized(false);
        window.setResizable(false);;

        // Add listeners
        window.addGLEventListener(new EventListener(new Game()));
        window.addMouseListener(new MouseInputCaller());
        window.addKeyListener(new KeyInputCaller());
        
        // start the animator and make the window visible
        animator = new FPSAnimator(window, 130);
        animator.start();
   
        window.setVisible(true);

        // https://github.com/jvm-graphics-labs/hello-triangle/blob/master/src/main/java/gl4/HelloTriangleSimple.java
        // End when the window is exited
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyed(WindowEvent e) {
                ExitProgram();
            }
        });
        
    }

    /**
     * Stops the animator and exits the program
     */
    public static void ExitProgram(){
        animator.stop();
        System.exit(1);
    }

    /**
     * Gets and returns the gl profile
     * 
     * @return the GLProfile
     */
    public static GLProfile getProfile(){
        return profile;
    }
}
