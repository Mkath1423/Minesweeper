package engine.scenes;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    // all the scenes that can be activated
    private static Map<String, Scene> scenes;

    // the scene that is currently running
    private static Scene activeScene = null;

    // static constructor for the scenes map
    static {
        scenes = new HashMap<>();
    }

    /**
     * Adds a scene to the scenes map
     * 
     * @param sceneName the string name to reference the scene
     * @param scene the scene to add
     */
    public static void AddScene(String sceneName, Scene scene){
        // dont include null names or names that already exist 
        System.out.println("Adding scene: " + sceneName);
        if(scene == null) return;
        if(scenes.containsKey(sceneName)) return;

        // Invoke the awake callback and store the scene
        scene.Awake();
        scenes.put(sceneName, scene);
        
    }
    
    /**
     * Start a scene
     * 
     * Makes the scene run and render
     * 
     * @param sceneName the name of the scene to start
     */
    public static void StartScene(String sceneName){
        // return if the scene does not exist
        if(!scenes.containsKey(sceneName)) return;
        if(scenes.get(sceneName) == null)  return;
        
        // Invoke the end method for whatever scene was running
        if(activeScene != null){
            activeScene.End();
        }

        System.out.println("Starting scene: " + sceneName);

        // Get the new active scene and start it if its not null
        activeScene = scenes.get(sceneName);
        
        if(activeScene != null){
            activeScene.Start();
        }
    }

    public static void Update(int i) {
    }
}
