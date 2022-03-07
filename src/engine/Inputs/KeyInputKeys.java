package engine.Inputs;

import java.util.HashMap;
import java.util.Map;

public enum KeyInputKeys{
    A(0x41),
    B(0x42),
    C(0x43),
    D(0x44),
    E(0x45),
    F(0x46),
    G(0x47),
    H(0x48),
    I(0x49),
    J(0x4a),
    K(0x4b),
    L(0x4c),
    M(0x4d),
    N(0x4e),
    O(0x4f),
    P(0x50),
    Q(0x51),
    R(0x52),
    S(0x53),
    T(0x54),
    U(0x55),
    V(0x56),
    W(0x57),
    X(0x58),
    Y(0x59),
    Z(0x5a)
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