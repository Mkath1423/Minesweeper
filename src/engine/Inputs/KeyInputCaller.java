package engine.Inputs;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInputCaller implements KeyListener{

    @Override
    public void keyPressed(KeyEvent event) {
        //System.out.println(event.toString());
        KeyInput.raiseListeners(KeyInputKeys.get(event.getKeyCode()), event);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        KeyInput.raiseListeners(KeyInputKeys.get(event.getKeyCode()), event);
    }
    
}
