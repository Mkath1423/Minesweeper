package engine.components;

/** 
 * An object that can be added to the scenes
 * 
 * Contains components that add extra functionality 
 * 
 * @author Lex Stapleton
*/
public abstract class GameObject {
    
    public boolean isActive = false;

    // !! No need to call these methods manually, the SceneManager will handle that.

    // Called when GO is added to a scene
    //    Use this for first time only initializations
    public void Awake() {};

    // Called when a scene with this GO begins
    //    The gets called each time the scene restarts
    //    Use it for initializing stuff 
    public void Start() {};

    // Called every frame when the scene is active
    //   given the time between frames
    public void Update(float dt) {};

    // Called before a scene ends
    //   Use this for finalizations
    public void End() {};
}
