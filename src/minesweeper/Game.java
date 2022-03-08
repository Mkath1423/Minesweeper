package minesweeper;

import engine.GameLoop;
import engine.rendering.geometry.Point;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;

public class Game implements GameLoop{

    public Tile[][] tiles;

    public Tile tile;

    @Override
    public void init() {
        /*
        Point initalPosition = new Point(100f, 0f);

        tiles = new Tile[Constants.kGame.ySize][Constants.kGame.xSize];

        for (int y = 0; y < Constants.kGame.ySize; y++){
            for(int x = 0; x < Constants.kGame.xSize; x++){
                tiles[y][x] = new Tile(initalPosition.x + x*Constants.kTile.length, 
                                       initalPosition.y + y*Constants.kTile.length, 
                                       Constants.kTile.length);
            }
        }
        */
        tile = new Tile(new Point(0, 0), 100);
    }

    @Override
    public void update(double time) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
    
}
