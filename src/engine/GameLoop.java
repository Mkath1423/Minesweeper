package engine;

public interface GameLoop {
    public void init();
    public void update(double time);
    public void dispose();
}
