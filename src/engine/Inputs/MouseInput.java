package engine.Inputs;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.jogamp.newt.event.MouseEvent;

public class MouseInput {
    private static Map<MouseInputs, List<Consumer<MouseEvent>>> listeners;

    public void init(){
        listeners = new EnumMap<MouseInputs, List<Consumer<MouseEvent>>>(MouseInputs.class);

        for (MouseInputs mouseInput : MouseInputs.values()) {
            listeners.put(mouseInput, new ArrayList<Consumer<MouseEvent>>());
        }
    }

    public static int register(MouseInputs event, Consumer<MouseEvent> consumer){
        return listeners.get(event).length();
    }
}
