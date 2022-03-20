package engine.scenes;

import java.util.ArrayList;
import java.util.List;

import engine.components.GameObject;
import minesweeper.Game;

public class Scene {
    protected List<GameObject> gameObjects;

    public Scene(){
        gameObjects = new ArrayList<>();
    }

    public Scene(List<GameObject> _gameObjects){
        gameObjects = _gameObjects;
    }

    public void AddGameObject(GameObject go){
        gameObjects.add(go);
    }

    public void RemoveGameObject(GameObject go){
        gameObjects.remove(gameObjects.indexOf(go));
    }

    public void Awake(){
        for (GameObject gameObject : gameObjects) {
            gameObject.Awake();
        }
    }

    public void Start(){
        for (GameObject gameObject : gameObjects) {
            gameObject.Start();
            gameObject.isActive = true;
        }
    }

    public void Update(float dt){
        for (GameObject gameObject : gameObjects) {
            gameObject.Update(dt);
        }
    }

    public void End(){
        for (GameObject gameObject : gameObjects) {
            gameObject.End();
            gameObject.isActive = false;
        }
    }
}
