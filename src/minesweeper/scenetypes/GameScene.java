package minesweeper.scenetypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.components.GameObject;
import engine.components.Transform;
import engine.components.Transform.PositionMode;
import engine.physics2D.collisions.Vector2;
import engine.rendering.Renderer;
import engine.rendering.geometry.Point;
import engine.resourse.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import engine.ui.elements.UIButton;
import minesweeper.Constants;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.TileGO;

public class GameScene extends Scene{
    
    private TileGO[][] tiles;

    public double difficulty = 0;

    private int flagsCounter = -1;
    private int trueBombsLeftCounter = -1;

    public void Awake(){
        // Setup UIButtons
        UIButton<Boolean> exitButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16),
                                                                                     0f,
                                                                                 new Vector2(32f, 32f),
                                                                                     PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
        exitButton.event.registerListener((b) ->{
            Renderer.ExitProgram();
        } );

        UIButton<Boolean> restartButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16 - 40),
                                                                                        0f,
                                                                                    new Vector2(32f, 32f),
                                                                                        PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
        restartButton.event.registerListener((b) ->{
            SceneManager.StartScene("game");
        } );

        UIButton<Boolean> backButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16 - 80),
                                                                                     0f,
                                                                                 new Vector2(32f, 32f),
                                                                                     PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
        backButton.event.registerListener((b) ->{
            SceneManager.StartScene("home");
        } );

        AddGameObject(backButton);
        AddGameObject(restartButton);
        AddGameObject(exitButton);

        // Initialize Tile GameObjects
        Point initialPosition = new Point(245f, 47f);

        tiles = new TileGO[Constants.kGame.ySize][Constants.kGame.xSize];

        for (int y = 0; y < Constants.kGame.ySize; y++){
            for(int x = 0; x < Constants.kGame.xSize; x++){
                tiles[y][x] = new TileGO(new Vector2(initialPosition.x + x*Constants.kTile.length, 
                                                     initialPosition.y + y*Constants.kTile.length));
            }
        }

        // Add tiles to screen
        for (TileGO[] row : tiles) {
            for (TileGO tile : row) {
                tile.onTileFlagged  .registerListener(this::TileIsFlagged);
                tile.onTileUnflagged.registerListener(this::TileIsUnFlagged);
                tile.onTileRevealed .registerListener(this::TileIsRevealed);
                
                AddGameObject(tile);
            }
        }

        super.Awake();
    }

    public void Start(){
        System.out.println("Game Starting");
        // make all tile non bombs
        for (TileGO[] row : tiles) {
            for (TileGO tile : row) {
                tile.isBomb = false;
                tile.count = 0;
                tile.gameIsOver = false;
            }
        }

        // choose random tiles and make them bombs
        List<Integer> allIndices = new ArrayList<Integer>();

        for(int i = 0; i < kGame.ySize * kGame.xSize ; i++){
            allIndices.add(i);
        }

        Collections.shuffle(allIndices);

        trueBombsLeftCounter = (int)(allIndices.size() * difficulty);
        flagsCounter         = (int)(allIndices.size() * difficulty);

        List<Integer> bombIndices = allIndices.subList(0, (int)(allIndices.size() * difficulty));

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

        super.Start();
    }

    public void Update(float dt){
        super.Update(dt);
    }

    public void End(){
        super.End();
    }

    public void TileIsRevealed(boolean isBomb){
        if(!isBomb) return;
    
        // trigger bad ending

        for (TileGO[] row : tiles) {
            for (TileGO tile : row) {
                tile.RevealTile();
                tile.gameIsOver = true;
            }
        }
    }

    public void TileIsFlagged(boolean isBomb){
        flagsCounter --;
        if(isBomb){
            trueBombsLeftCounter --;
        }
    }

    public void TileIsUnFlagged(boolean isBomb){
        flagsCounter ++;
        if(isBomb){
            trueBombsLeftCounter ++;
        }
    }

}
