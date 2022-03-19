package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.GameLoop;
import engine.components.Image;
import engine.components.Transform;
import engine.components.Transform.PositionMode;
import engine.physics2D.collisions.Vector2;
import engine.rendering.Renderer;
import engine.rendering.geometry.Point;
import engine.resourse.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import engine.ui.elements.UIButton;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;
import minesweeper.gametypes.TileGO;

public class Game implements GameLoop{

    public static void main(String[] args){
        System.out.println("Game.main()");
        Renderer.init();
    }

    // Scenes

    Scene homeScreen;
    Scene gameScreen;
    Scene endScreen;

    public TileGO[][] tiles;


    @Override
    public void init() {

        System.out.println("GameLoop.init()");

        // Initialize Tile GameObjects
        Point initialPosition = new Point(0f, 0f);

        tiles = new TileGO[Constants.kGame.ySize][Constants.kGame.xSize];

        for (int y = 0; y < Constants.kGame.ySize; y++){
            for(int x = 0; x < Constants.kGame.xSize; x++){
                tiles[y][x] = new TileGO(new Vector2(initialPosition.x + x*Constants.kTile.length, 
                                                     initialPosition.y + y*Constants.kTile.length));
            }
        }
        
        List<Integer> allIndices = new ArrayList<Integer>();

        for(int i = 0; i < kGame.ySize * kGame.xSize ; i++){
            allIndices.add(i);
        }

        Collections.shuffle(allIndices);

        List<Integer> bombIndices = allIndices.subList(0, (int)(allIndices.size() * kGame.easyBombsAmount));

        for(Integer i : bombIndices){
            int x = i % kGame.xSize;
            int y = i / kGame.xSize;

            tiles[y][x].isBomb = true;

            if(x > 0 && y > 0){
                tiles[y-1][x-1].count ++;
            }

            if(x > 0){
                tiles[y][x-1].count ++;
            }

            if(x > 0 && y < kGame.ySize - 1){
                tiles[y+1][x-1].count ++;
            }

            if(y > 0){
                tiles[y-1][x].count ++;
            }

            if(y < kGame.ySize - 1){
                tiles[y+1][x].count ++;
            }

            if(x < kGame.xSize - 1 && y < kGame.ySize - 1){
                tiles[y+1][x+1].count ++;
            }

            if(x < kGame.xSize - 1){
                tiles[y][x+1].count ++;
            }

            if(x < kGame.xSize - 1 && y > 0){
                tiles[y-1][x+1].count ++;
            }
        }

        // Initialize UI Elements
        UIButton<Integer> startButton = new UIButton<Integer>(0, new Transform(new Vector2(100, 100), 
                                                                                   0f, 
                                                                               new Vector2(128f, 64f), 
                                                                                   PositionMode.LEFT_TOP), 
                                                                     ImageResource.getSpriteMap("Button1Default.png"), 
                                                                     ImageResource.getSpriteMap("Button1Pressed.png"), 
                                                                     ImageResource.getSpriteMap("Button1Hovering.png"));


        startButton.event.registerListener((i) -> {
            SceneManager.StartScene("game");
        });


        // Home Screen
        homeScreen = new Scene();

        homeScreen.AddGameObject(startButton);

        // Game Scene
        gameScreen = new Scene();

        // Add tiles to screen
        for (TileGO[] row : tiles) {
            for (TileGO tile : row) {
                gameScreen.AddGameObject(tile);
            }
        }

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
