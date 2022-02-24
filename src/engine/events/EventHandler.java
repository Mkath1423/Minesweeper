package engine.events;

public interface EventHandler<T> {
    public boolean isRaised();
    public void raiseListeners(T data);
    public int registerListener(EventListener<T> listener);
    public void unregisterListener(int index);
}
