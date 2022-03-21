package minesweeper;

import engine.GameLoop;
import engine.components.Transform;
import engine.components.Transform.PositionMode;
import engine.physics2D.collisions.Vector2;
import engine.rendering.Renderer;
import engine.resource.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import engine.ui.elements.UIButton;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;
import minesweeper.scenetypes.GameScene;

public class Game implements GameLoop {

    // Game entry point
    //  initalizes the renderer
    public static void main(String[] args) {
        System.out.println("Game.main()");
        Renderer.init();
    }

    // Scenes
    Scene homeScene;
    GameScene gameScene;
    Scene endScene;

    @Override
    public void init() {
        System.out.println("GameLoop.init()");

        // Initialize UI Elements
        // Start button for easy difficulty 
        UIButton<Double> startButtonEasy = new UIButton<Double>(kGame.easyBombsAmount, new Transform(new Vector2(320, 80),
                                                                                                         0f,
                                                                                                     new Vector2(128f, 64f),
                                                                                                         PositionMode.MIDDLE_CENTER),

                                                                ImageResource.getSpriteMap("Button1Default.png"),
                                                                ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                ImageResource.getSpriteMap("Button1Hovering.png"));

        // Start button for medium difficulty 
        UIButton<Double> startButtonMedium = new UIButton<Double>(kGame.mediumBombsAmount, new Transform(new Vector2(320, 160),
                                                                                                             0f,
                                                                                                         new Vector2(128f, 64f),
                                                                                                             PositionMode.MIDDLE_CENTER),
                                                                                                        
                                                                    ImageResource.getSpriteMap("Button1Default.png"),
                                                                    ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                    ImageResource.getSpriteMap("Button1Hovering.png"));

        // Start button for hard difficulty 
        UIButton<Double> startButtonHard = new UIButton<Double>(kGame.hardBombsAmount, new Transform(new Vector2(320, 240),
                                                                                                         0f,
                                                                                                     new Vector2(128f, 64f),
                                                                                                         PositionMode.MIDDLE_CENTER),
                                                                ImageResource.getSpriteMap("Button1Default.png"),
                                                                ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                ImageResource.getSpriteMap("Button1Hovering.png"));

        // Exit program button
        UIButton<Boolean> exitButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16),
                                                                0f,
                                                            new Vector2(32f, 32f),
                                                                PositionMode.RIGHT_BOTTOM),
                                        
                                        ImageResource.getSpriteMap("Button1Default.png"),
                                        ImageResource.getSpriteMap("Button1Pressed.png"),
                                        ImageResource.getSpriteMap("Button1Hovering.png"));

        // Add callbacks for switching to the game scene
        //     set the difficulty when the callback is triggered
        startButtonEasy.event.registerListener((i) -> {
            gameScene.difficulty = i;
            SceneManager.StartScene("game");
        });

        startButtonMedium.event.registerListener((i) -> {
            gameScene.difficulty = i;
            SceneManager.StartScene("game");
        });

        startButtonHard.event.registerListener((i) -> {
            gameScene.difficulty = i;
            SceneManager.StartScene("game");
        });

        // Set the callback for exiting the program
        exitButton.event.registerListener((b) ->{
            Renderer.ExitProgram();
        } );

        // Home Screen
        homeScene = new Scene();

        homeScene.AddGameObject(startButtonEasy);
        homeScene.AddGameObject(startButtonMedium);
        homeScene.AddGameObject(startButtonHard);
        homeScene.AddGameObject(exitButton);

        // Game Screen
        gameScene = new GameScene();

        // End Scene
        // TODO: make this something (maybe...)
        endScene = new Scene();

        // Add Scenes to Manager and start initial scene
        SceneManager.AddScene("home", homeScene);
        SceneManager.AddScene("game", gameScene);
        SceneManager.AddScene("end", endScene);

        SceneManager.StartScene("home");
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub
        // Not used

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        // Not used
    }

    @Override
    public void loadTextures() {
        // load the textures that are being used
        // called when the program starts
        System.out.println("GameLoop.LoadTextures()");

        ImageResource.loadImage("2000.png", 8, 2);
        ImageResource.loadImage("font.png", 9, 8);

        ImageResource.loadImage("Button1Default.png");
        ImageResource.loadImage("Button1Pressed.png");
        ImageResource.loadImage("Button1Hovering.png");

    }

}
