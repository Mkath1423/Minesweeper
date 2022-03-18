package engine.components;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Event<T>{
    private List<Consumer<T>> listeners; 

    public Event(){
        listeners = new ArrayList<Consumer<T>>();
    }

    public void registerListener(Consumer<T> callback){
        listeners.add(callback);
    }

    public void invoke(T data){
        for (Consumer<T> consumer : listeners) {
            consumer.accept(data);
        }
    }
}
