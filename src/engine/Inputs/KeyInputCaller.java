package engine.Inputs;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInputCaller implements KeyListener{

    /**
     * Raises key input listeners when a key is pressed
     */
    @Override
    public void keyPressed(KeyEvent event) {
        KeyInput.raiseListeners(KeyInputKeys.get(event.getKeyCode()), event);
    }

    /**
     * Raises key input listeners when a key is released 
     */
    @Override
    public void keyReleased(KeyEvent event) {
        KeyInput.raiseListeners(KeyInputKeys.get(event.getKeyCode()), event);
    }
    
}
