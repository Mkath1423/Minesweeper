package engine.scenes;

import java.util.ArrayList;
import java.util.List;

import engine.components.GameObject;
import minesweeper.Game;

public class Scene {
    // game objects that exist within the scene
    protected List<GameObject> gameObjects;

    /**
     * constructs a new scene
     */
    public Scene(){
        gameObjects = new ArrayList<>();
    }

    /**
     * Constructs a new scene with the given game objects
     * 
     * @param _gameObjects the game object that are in the scene
     */
    public Scene(List<GameObject> _gameObjects){
        gameObjects = _gameObjects;
    }

    /**
     * Adds a GameObject to the scene
     * 
     * @param go the GameObject to add to the scene
     */
    public void AddGameObject(GameObject go){
        gameObjects.add(go);
    }

    /**
     * Removes a GameObject from the scene
     * 
     * @param go the GameObject to remove from the scene
     */
    public void RemoveGameObject(GameObject go){
        gameObjects.remove(gameObjects.indexOf(go));
    }

    /**
     * Called when the scene is first added to the SceneManager
     * 
     * Invokes the Awake() method for all GameObjects
     * 
     * If you make a subclass, initialize GameObjects here
     */
    public void Awake(){
        for (GameObject gameObject : gameObjects) {
            gameObject.Awake();
        }
    }

    /**
     * Called each time the scene starts 
     * 
     * Invokes the Start() method for all gameobjects
     * 
     * Sets all gameobjects to be active
     */
    public void Start(){
        for (GameObject gameObject : gameObjects) {
            gameObject.Start();
            gameObject.isActive = true;
        }
    }

    /**
     * Called each time the game cycles
     * 
     * Invokes the Update() method for all gameobjects
     */
    public void Update(float dt){
        for (GameObject gameObject : gameObjects) {
            gameObject.Update(dt);
        }
    }

    /**
     * Called each time the scene ends
     * 
     * Invokes the End() method for all gameobjects
     * 
     * Sets all gameobjects to inactive
     */
    public void End(){
        for (GameObject gameObject : gameObjects) {
            gameObject.End();
            gameObject.isActive = false;
        }
    }
}
