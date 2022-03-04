package engine.Inputs;

import java.util.HashMap;
import java.util.Map;

public enum KeyInputKeys{
    ;
    private final int keyCode;


    // CREDIT: https://stackoverflow.com/questions/1080904/how-can-i-lookup-a-java-enum-from-its-string-value
    private static final Map<Integer, KeyInputKeys> lookup = new HashMap<Integer, KeyInputKeys>();

    static {
        for (KeyInputKeys k : KeyInputKeys.values()) {
            lookup.put(k.getKeyCode(), k);
        }
    }

    private KeyInputKeys(int code){
        this.keyCode = code;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public static KeyInputKeys get(int keyCode){
        return lookup.get(keyCode);
    }

    
}