package engine.events;

import java.util.function.Consumer;

public interface EventHandler<T> {
    public boolean isRaised();
    public void raiseListeners(T data);
    public int register(Consumer<T> listener);
    public void unregister(int index);
}
