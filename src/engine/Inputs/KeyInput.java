package engine.Inputs;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.jogamp.newt.event.KeyEvent;

public class KeyInput{
    private static Map<KeyInputKeys, List<Consumer<KeyEvent>>> listeners;

    // Static initializer for the listeners map
    static {
        listeners = new EnumMap<KeyInputKeys, List<Consumer<KeyEvent>>>(KeyInputKeys.class);

        for (KeyInputKeys mouseInput : KeyInputKeys.values()) {
            listeners.put(mouseInput, new ArrayList<Consumer<KeyEvent>>());
        }
    }

    
    /** 
     * Send key data to listeners
     * 
     * Invokes all the listeners associated with the KeyEvent.
     * Data gets passed in as a parameter.
     * 
     * @param key the key code from KeyInputKey enum
     * @param data the key event containing info about the event
     */
    public static void raiseListeners(KeyInputKeys key, KeyEvent data){
        if(!listeners.containsKey(key)) return;
        
        for(Consumer<KeyEvent> consumer : listeners.get(key)){
            consumer.accept(data);
        }
    }

    
    /** 
     * Add a listener to the listeners.
     * 
     * Append a lambda to listeners, gets called when the event is raised.
     * 
     * @param key the KeyEvent this callback is associated with
     * @param consumer a KeyEvent Consumer that will get invoked when an event is triggered
     * @return int the index in the listener list TODO: this return won't work
     */
    public static int register(KeyInputKeys key, Consumer<KeyEvent> consumer){
        listeners.get(key).add(consumer);
        return listeners.get(key).size() - 1;
    }

    
    /** 
     * Removes the listener from the list of callbacks
     * 
     * @param key the KeyEvent this callback is associated with
     * @param index the index of the callback
     */
    public static void unregister(KeyInputKeys key, int index){
        // TODO: this doesn't work
        if(index > listeners.get(key).size() -1) return;

        listeners.get(key).remove(index);

    }

}
