package engine.components;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/** 
 * An event component
 * 
 * Objects add themselves to the listeners
 * 
 * GO can call invoke to pass data to those listeners at a specific time
 * 
 * @author Lex Stapleton
*/
public class Event<T>{
    private List<Consumer<T>> listeners; 

    // Constructs the Event
    public Event(){
        listeners = new ArrayList<Consumer<T>>();
    }
    
    /** 
     * Add a listener to the listeners.
     * 
     * Append a lambda to listeners, gets called when the event is invoked.
     *  
     * @param callback
     */
    public void registerListener(Consumer<T> callback){
        if(callback == null) return;
        listeners.add(callback);
    }

    
    /** 
     * Send the data to all listener methods.
     * 
     * Invoke all the listeners and give them the specified data as a parameter.
     * 
     * @param data
     */
    public void invoke(T data){
        for (Consumer<T> consumer : listeners) {
            if(consumer != null){
                consumer.accept(data);
            }
        }
    }
}
