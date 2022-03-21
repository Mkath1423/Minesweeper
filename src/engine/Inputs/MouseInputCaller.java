package engine.Inputs;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInputCaller implements MouseListener{
    
    /**
     * I don't know when this will trigger
     */
    @Override
    public void mouseExited(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.EXITED, data);
    }

    /**
     * Triggers when the mouse is held and dragged
     */
    @Override
    public void mouseDragged(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.DRAGGED, data);
    }

    /**
     * Triggers when the mouse is initially released
     */
    @Override
    public void mouseReleased(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.RELEASED, data);
    }

    /**
     * Triggers when the mouse pressed and released quickly (maybe?)
     */
    @Override
    public void mouseClicked(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.CLICKED, data);
    }

    /**
     * Triggers when the mouse is initially pressed
     */

    @Override
    public void mousePressed(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.PRESSED, data);
    }

    /**
     * I don't know what this does
     */
    @Override
    public void mouseEntered(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.ENTERED, data);
    }

    /**
     * Triggers when the mouse moves
     */
    @Override
    public void mouseMoved(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.MOUSEMOVED, data);
    }

    /**
     * Triggers when the mouse wheel moves
     */
    @Override
    public void mouseWheelMoved(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.WHEELMOVED, data);
    }

}
