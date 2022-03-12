package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.GameLoop;
import engine.rendering.geometry.Point;
import engine.resourse.ImageResource;
import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;

public class Game implements GameLoop{

    public Tile[][] tiles;


    @Override
    public void init() {
        Point initialPosition = new Point(0f, 0f);

        tiles = new Tile[Constants.kGame.ySize][Constants.kGame.xSize];

        for (int y = 0; y < Constants.kGame.ySize; y++){
            for(int x = 0; x < Constants.kGame.xSize; x++){
                tiles[y][x] = new Tile(initialPosition.x + x*Constants.kTile.length, 
                                       initialPosition.y + y*Constants.kTile.length, 
                                       Constants.kTile.length);
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

            System.out.printf("%s --> (%s, %s)\n", i, x, y);

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
