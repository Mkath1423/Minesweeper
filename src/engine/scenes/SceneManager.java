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
        if(activeScene.equals(null)) return;

        if(!scenes.containsKey(sceneName)){
            scene.Awake();
            scenes.put(sceneName, scene);
        }
    }
    
    public static void StartScene(String sceneName){
        if(!scenes.containsKey(sceneName)) return;
        
        if(!activeScene.equals(null)){
            activeScene.End();
        }

        activeScene = scenes.get(sceneName);
        
        if(!activeScene.equals(null)){
            activeScene.Start();
        }
    }
}
