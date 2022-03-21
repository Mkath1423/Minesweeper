package engine.Inputs;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.jogamp.newt.event.MouseEvent;

public class MouseInput{
    private static Map<MouseInputKeys, List<Consumer<MouseEvent>>> listeners;

    // Static initializer for the listeners map
    static {
        listeners = new EnumMap<MouseInputKeys, List<Consumer<MouseEvent>>>(MouseInputKeys.class);

        for (MouseInputKeys mouseInput : MouseInputKeys.values()) {
            listeners.put(mouseInput, new ArrayList<Consumer<MouseEvent>>());
        }
    }

    /** 
     * Send mouse data to listeners
     * 
     * Invokes all the listeners associated with the KeyEvent.
     * Data gets passed in as a parameter.
     * 
     * @param key the key value from MouseInputKeys enum
     * @param data the mouse event containing info about the event
     */
    public static void raiseListeners(MouseInputKeys key, MouseEvent data){
        if(!listeners.containsKey(key)) return;

        for(Consumer<MouseEvent> consumer : listeners.get(key)){
            consumer.accept(data);
        }
    }

    /** 
     * Add a listener to the listeners.
     * 
     * Append a lambda to listeners, gets called when the event is raised.
     * 
     * @param key the MouseEvent this callback is associated with
     * @param consumer a MouseEvent Consumer that will get invoked when an event is triggered
     * @return int the index in the listener list TODO: this return won't work
     */
    public static int register(MouseInputKeys key, Consumer<MouseEvent> consumer){
        listeners.get(key).add(consumer);
        return listeners.get(key).size() - 1;
    }

    /** 
     * Removes the listener from the list of callbacks
     * 
     * @param key the MouseEvent this callback is associated with
     * @param index the index of the callback
     */
    public static boolean unregister(MouseInputKeys key, int index){
        if(index > listeners.get(key).size() -1) return false;

        listeners.get(key).remove(index);

        return true;
    }

}
