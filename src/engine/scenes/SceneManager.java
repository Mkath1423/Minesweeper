package engine.scenes;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static Map<String, Scene> scenes;

    private static Scene activeScene = null;

    static {
        scenes = new HashMap<>();
    }

    public static void AddScene(String sceneName, Scene scene){
        System.out.println("Adding scene: " + sceneName);
        if(scene == null) return;

        if(!scenes.containsKey(sceneName)){
            scene.Awake();
            scenes.put(sceneName, scene);
        }
    }
    
    public static void StartScene(String sceneName){
        if(!scenes.containsKey(sceneName)) return;
        
        if(activeScene != null){
            activeScene.End();
        }

        System.out.println("Starting scene: " + sceneName);

        activeScene = scenes.get(sceneName);
        
        if(activeScene != null){
            activeScene.Start();
        }
    }
}
