package engine.Inputs;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.jogamp.newt.event.MouseEvent;

import engine.events.EventHandler;

public class MouseInput{
    private static Map<MouseInputKeys, List<Consumer<MouseEvent>>> listeners;

    public static void init(){
        listeners = new EnumMap<MouseInputKeys, List<Consumer<MouseEvent>>>(MouseInputKeys.class);

        for (MouseInputKeys mouseInput : MouseInputKeys.values()) {
            listeners.put(mouseInput, new ArrayList<Consumer<MouseEvent>>());
        }
    }

    public static void raiseListeners(MouseInputKeys key, MouseEvent data){
        for(Consumer<MouseEvent> consumer : listeners.get(key)){
            consumer.accept(data);
        }
    }

    public static int register(MouseInputKeys key, Consumer<MouseEvent> consumer){
        return listeners.get(key).size() - 1;
    }

    public static boolean unregister(MouseInputKeys key, int index){
        if(index > listeners.get(key).size() -1) return false;

        listeners.get(key).remove(index);

        return true;
    }

}
