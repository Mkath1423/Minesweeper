package minesweeper.util;

import java.util.ArrayList;
import java.util.Collections;

public class GameUtils {

    public static int[] getRandomBombs(int numBombs, int size){
        ArrayList<Integer> tiles = new ArrayList<Integer>();

        for(int i = 0; i != size; i++){
            tiles.add(i);
        }

        Collections.shuffle(tiles);

        int[] bombs = new int[numBombs];

        for(int i = 0; i != numBombs; i++){
            bombs[i] = tiles.get(i);
        }

        return bombs;
    }
    
}
