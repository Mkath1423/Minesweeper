package engine.Inputs;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;

public class KeyInput{
    private static Map<KeyInputKeys, List<Consumer<KeyEvent>>> listeners;

    static {
        listeners = new EnumMap<KeyInputKeys, List<Consumer<KeyEvent>>>(KeyInputKeys.class);

        for (KeyInputKeys mouseInput : KeyInputKeys.values()) {
            listeners.put(mouseInput, new ArrayList<Consumer<KeyEvent>>());
        }
    }

    public static void raiseListeners(KeyInputKeys key, KeyEvent data){
        if(!listeners.containsKey(key)) return;
        
        for(Consumer<KeyEvent> consumer : listeners.get(key)){
            consumer.accept(data);
        }
    }

    public static int register(KeyInputKeys key, Consumer<KeyEvent> consumer){
        listeners.get(key).add(consumer);
        return listeners.get(key).size() - 1;
    }

    public static boolean unregister(KeyInputKeys key, int index){
        if(index > listeners.get(key).size() -1) return false;

        listeners.get(key).remove(index);

        return true;
    }

}
