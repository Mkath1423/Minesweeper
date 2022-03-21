package engine;

public interface GameLoop {

    /**
     * Load sprites into the ImageResource
     * 
     * Always called before init
     */
    public void loadTextures();

    /**
     * Initialize scenes and game objects 
     */
    public void init();

    /**
     * Called every frame 
     * 
     * @param time the time between this frame and the last
     */
    public void update(double time);

    /**
     * Called when the window closes
     */
    public void dispose();
}
