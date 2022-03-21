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
import engine.resource.ImageResource;
import engine.scenes.Scene;
import engine.scenes.SceneManager;
import engine.ui.elements.UIButton;
import minesweeper.Constants;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;

public class GameScene extends Scene{
    
    private Tile[][] tiles;

    public double difficulty = 0;

    // Counters for displaying game info // TODO: display counter
    private int flagsCounter = -1;
    private int trueBombsLeftCounter = -1;

    @Override
    public void Awake(){
        // Setup UIButtons

        // Button for exiting program
        UIButton<Boolean> exitButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16),
                                                                                     0f,
                                                                                 new Vector2(32f, 32f),
                                                                                     PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
        // register callback
        exitButton.event.registerListener((b) ->{
            Renderer.ExitProgram();
        } );

        // button for restarting the game
        UIButton<Boolean> restartButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16 - 40),
                                                                                        0f,
                                                                                    new Vector2(32f, 32f),
                                                                                        PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
                                                             // register callback
        restartButton.event.registerListener((b) ->{
            SceneManager.StartScene("game");
        } );

        // button for returning to home screen
        UIButton<Boolean> backButton = new UIButton<Boolean>(true, new Transform(new Vector2(640 - 16, 320 - 16 - 80),
                                                                                     0f,
                                                                                 new Vector2(32f, 32f),
                                                                                     PositionMode.RIGHT_BOTTOM),
                                                             
                                                             ImageResource.getSpriteMap("Button1Default.png"),
                                                             ImageResource.getSpriteMap("Button1Pressed.png"),
                                                             ImageResource.getSpriteMap("Button1Hovering.png"));
        
        // register callback
        backButton.event.registerListener((b) ->{
            SceneManager.StartScene("home");
        } );

        AddGameObject(backButton);
        AddGameObject(restartButton);
        AddGameObject(exitButton);

        // Construct Tile GameObjects 
        Point initialPosition = new Point(245f, 47f);

        tiles = new Tile[Constants.kGame.ySize][Constants.kGame.xSize];

        for (int y = 0; y < Constants.kGame.ySize; y++){
            for(int x = 0; x < Constants.kGame.xSize; x++){
                tiles[y][x] = new Tile(new Vector2(initialPosition.x + x*Constants.kTile.length, 
                                                     initialPosition.y + y*Constants.kTile.length));
            }
        }

        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                // add listeners to tile events
                tile.onTileFlagged  .registerListener(this::TileIsFlagged);
                tile.onTileUnflagged.registerListener(this::TileIsUnFlagged);
                tile.onTileRevealed .registerListener(this::TileIsRevealed);

                // Add tiles to scene
                AddGameObject(tile);
            }
        }

        super.Awake();
    }

    @Override
    public void Start(){
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                // make all tile non bombs
                tile.isBomb = false;

                // reset count variables
                tile.count = 0;

                // mark game as started
                tile.gameIsOver = false;
            }
        }

        // choose random tiles and make them bombs
        List<Integer> allIndices = new ArrayList<Integer>();

        for(int i = 0; i < kGame.ySize * kGame.xSize ; i++){
            allIndices.add(i);
        }

        Collections.shuffle(allIndices);

        // initialize the counters
        trueBombsLeftCounter = (int)(allIndices.size() * difficulty);
        flagsCounter         = (int)(allIndices.size() * difficulty);

        List<Integer> bombIndices = allIndices.subList(0, (int)(allIndices.size() * difficulty));

        // loop through the chosen bomb tiles
        for(Integer i : bombIndices){
            int x = i % kGame.xSize;
            int y = i / kGame.xSize;

            // mark that tile as a bomb
            tiles[y][x].isBomb = true;

            // increment the bomb count of all adjacent tiles 
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

    @Override
    public void Update(float dt){
        super.Update(dt);
    }

    @Override
    public void End(){
        super.End();
    }

    /**
     * Called when ever a tile is revealed
     * 
     * If the tile is a bomb, end the game
     * 
     * @param isBomb
     */
    public void TileIsRevealed(boolean isBomb){
        if(!isBomb) return;
    
        // trigger bad ending

        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.RevealTile();
                tile.gameIsOver = true;
            }
        }
    }

    /**
     * Called when ever a tile is flagged
     * 
     * increment the trueBombsLeftCounter and flagsCounter 
     * 
     * @param isBomb
     */
    public void TileIsFlagged(boolean isBomb){
        flagsCounter --;
        if(isBomb){
            trueBombsLeftCounter --;
        }
    }

    /**
     * Called when ever a tile is flagged
     * 
     * decrement the trueBombsLeftCounter and flagsCounter 
     * 
     * @param isBomb
     */
    public void TileIsUnFlagged(boolean isBomb){
        flagsCounter ++;
        if(isBomb){
            trueBombsLeftCounter ++;
        }
    }

}
