package engine.Inputs;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class MouseInputCaller implements MouseListener{
    
    @Override
    public void mouseExited(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.EXITED, data);
    }

    @Override
    public void mouseDragged(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.DRAGGED, data);
    }

    @Override
    public void mouseReleased(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.RELEASED, data);
    }

    @Override
    public void mouseClicked(MouseEvent data){
        System.out.printf("(%s, %s)\n", data.getX(), data.getY());
        MouseInput.raiseListeners(MouseInputKeys.CLICKED, data);
    }

    @Override
    public void mousePressed(MouseEvent data){
        MouseInput.raiseListeners(MouseInputKeys.PRESSED, data);
    }

    @Override
    public void mouseEntered(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.ENTERED, data);
    }

    @Override
    public void mouseMoved(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.MOUSEMOVED, data);
    }

    @Override
    public void mouseWheelMoved(MouseEvent data) {
        MouseInput.raiseListeners(MouseInputKeys.WHEELMOVED, data);
    }

}
