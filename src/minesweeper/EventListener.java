package minesweeper;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import minesweeper.Constants.kGame;
import minesweeper.gametypes.Tile;
import minesweeper.util.*;

public class EventListener implements GLEventListener{
    public Tile[][] tiles;

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.draw(gl);
            }
        }

    
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        
        System.out.println("dispose");
    }

    @Override
    public void init(GLAutoDrawable drawable){
        GL2 gl = drawable.getGL().getGL2();
        tiles = new Tile[kGame.ySize][kGame.xSize];


        // init tiles
        for(int x = 0; x < kGame.xSize; x++ ){
            for(int y = 0; y < kGame.ySize; y++){
                tiles[x][y] = new Tile(x, y, 10);
            }
        }

        
        int[] bombs = GameUtils.getRandomBombs(40, kGame.xSize * kGame.ySize);

        for (int i : bombs) {
            int x = i % kGame.ySize;
            int y = i / kGame.xSize;

            tiles[y][x].isBomb = true;

            if(x > 0){
                tiles[x - 1][y].count += 1;
            }
            
            if(x < kGame.xSize - 1){
                tiles[x + 1][y].count += 1;
            }

            if(y > 0){
                tiles[x][y - 1].count += 1;
            }
            
            if(y < kGame.ySize - 1){
                tiles[x][y + 1].count += 1;
            }

            if(x > 0 && y > 0){
                tiles[x + 1][y + 1].count += 1;
            }

            if(x < kGame.xSize && y > 0){
                tiles[x - 1][y + 1].count += 1;
            }

            if(x > 0 && y < kGame.ySize){
                tiles[x + 1][y - 1].count += 1;
            }

            if(x < kGame.xSize && y < kGame.ySize){
                tiles[x - 1][y - 1].count += 1;
            }
        }


        gl.glClearColor(0.5f, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        
        gl.glLoadIdentity();

        gl.glOrtho(0, w, 0, h, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        System.out.println("reshape");
    }
    
}
