package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.GameLoop;
import engine.physics2D.collisions.Vector2;
import engine.rendering.geometry.Point;
import engine.resourse.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;
import minesweeper.gametypes.TileGO;

public class Game implements GameLoop{

    // Scenes

    Scene homeScreen;
    Scene gameScreen;
    Scene endScreen;

    public TileGO[][] tiles;


    @Override
    public void init() {

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
        //     TODO: Add UI here

        // Home Screen
        homeScreen = new Scene();

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
        SceneManager.AddScene("game", gameScreen);
        SceneManager.AddScene("home", homeScreen);
        SceneManager.AddScene("end", endScreen);

        SceneManager.StartScene("game");

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
        ImageResource.loadImage("2000.png", 8, 2);
    }
    
}
