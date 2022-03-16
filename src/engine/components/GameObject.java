package engine.components;

public abstract class GameObject {
    // !! Do not call these methods manually, the SceneManager will handle that.

    // Called when GO is added to a scene
    //    Use this for first time only initializations
    public abstract void Awake();

    // Called when a scene with this GO begins
    //    The gets called each time the scene restarts
    //    Use it for initializing stuff 
    public abstract void Start();

    // Called every frame when the scene is active
    //   given the time between frames
    public abstract void Update(float dt);

    // Called before a scene ends
    //   Use this for finalizations
    public abstract void End();
}
