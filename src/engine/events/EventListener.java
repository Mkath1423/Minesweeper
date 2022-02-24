package engine.events;

public interface EventListener<T> {
    public void raised(T data);
}
