package minesweeper;

import engine.GameLoop;
import engine.components.Transform;
import engine.components.Transform.PositionMode;
import engine.physics2D.collisions.Vector2;
import engine.rendering.Renderer;
import engine.resourse.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import engine.ui.elements.UIButton;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.TileGO;
import minesweeper.scenetypes.GameScene;

public class Game implements GameLoop {

    public static void main(String[] args) {
        System.out.println("Game.main()");
        Renderer.init();
    }

    // Scenes

    Scene     homeScreen;
    GameScene gameScreen;
    Scene     endScreen;

    public TileGO[][] tiles;

    @Override
    public void init() {

        System.out.println("GameLoop.init()");

        // Initialize UI Elements
        UIButton<Double> startButtonEasy = new UIButton<Double>(kGame.easyBombsAmount, new Transform(new Vector2(320, 80),
                                                                                                         0f,
                                                                                                     new Vector2(128f, 64f),
                                                                                                         PositionMode.MIDDLE_CENTER),

                                                                ImageResource.getSpriteMap("Button1Default.png"),
                                                                ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                ImageResource.getSpriteMap("Button1Hovering.png"));

        UIButton<Double> startButtonMedium = new UIButton<Double>(kGame.mediumBombsAmount, new Transform(new Vector2(320, 160),
                                                                                                             0f,
                                                                                                         new Vector2(128f, 64f),
                                                                                                             PositionMode.MIDDLE_CENTER),
                                                                                                        
                                                                    ImageResource.getSpriteMap("Button1Default.png"),
                                                                    ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                    ImageResource.getSpriteMap("Button1Hovering.png"));

        UIButton<Double> startButtonHard = new UIButton<Double>(kGame.hardBombsAmount, new Transform(new Vector2(320, 240),
                                                                                                         0f,
                                                                                                     new Vector2(128f, 64f),
                                                                                                         PositionMode.MIDDLE_CENTER),
                                                                ImageResource.getSpriteMap("Button1Default.png"),
                                                                ImageResource.getSpriteMap("Button1Pressed.png"),
                                                                ImageResource.getSpriteMap("Button1Hovering.png"));

                                                                UIButton<Boolean> exitButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16),
                                                                0f,
                                                            new Vector2(32f, 32f),
                                                                PositionMode.RIGHT_BOTTOM),
                                        
                                        ImageResource.getSpriteMap("Button1Default.png"),
                                        ImageResource.getSpriteMap("Button1Pressed.png"),
                                        ImageResource.getSpriteMap("Button1Hovering.png"));

        startButtonEasy.event.registerListener((i) -> {
            gameScreen.difficulty = i;
            SceneManager.StartScene("game");
        });

        startButtonMedium.event.registerListener((i) -> {
            gameScreen.difficulty = i;
            SceneManager.StartScene("game");
        });

        startButtonHard.event.registerListener((i) -> {
            gameScreen.difficulty = i;
            SceneManager.StartScene("game");
        });

        exitButton.event.registerListener((b) ->{
            Renderer.ExitProgram();
        } );
            
            

        // Home Screen
        homeScreen = new Scene();

        homeScreen.AddGameObject(startButtonEasy);
        homeScreen.AddGameObject(startButtonMedium);
        homeScreen.AddGameObject(startButtonHard);
        homeScreen.AddGameObject(exitButton);

        // Game Screen
        gameScreen = new GameScene();

        // End Scene
        endScreen = new Scene();

        // Add Scenes to Manager and start initial scene
        SceneManager.AddScene("home", homeScreen);
        SceneManager.AddScene("game", gameScreen);
        SceneManager.AddScene("end", endScreen);

        SceneManager.StartScene("home");
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadTextures() {
        System.out.println("GameLoop.LoadTextures()");

        ImageResource.loadImage("2000.png", 8, 2);
        ImageResource.loadImage("font.png", 9, 8);

        ImageResource.loadImage("Button1Default.png");
        ImageResource.loadImage("Button1Pressed.png");
        ImageResource.loadImage("Button1Hovering.png");

    }

}
