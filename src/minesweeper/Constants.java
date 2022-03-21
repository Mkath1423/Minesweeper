package minesweeper;

public final class Constants {
    public static final class kTile{

        // tile size
        public static float length = 15;

        // Indices for sprites in the sprite map
        public static int UNCHECKED = 0;
        public static int EMPTY = 1;
        public static int FLAGGED = 2;
        public static int BOMB_NOT_FOUND = 5;
        public static int BOMB_CLICKED = 6;
        public static int NOT_BOMB = 7;
        public static int ONE = 8;
        public static int TWO = 9;
        public static int THREE = 10;
        public static int FOUR = 11;
        public static int FIVE = 12;
        public static int SIX = 13;
        public static int SEVEN = 14;
        public static int EIGHT = 15;

        public static final int[] COUNT_IMAGES = {1, 8, 9, 10, 11, 12, 13, 14, 15};

    }

    public static final class kGame{
        // size of bomb grid
        public static int xSize = 10;
        public static int ySize = 15;

        // Percentage of tiles that are bombs
        public static final double easyBombsAmount = 0.1;
        public static final double mediumBombsAmount = 0.2;
        public static final double hardBombsAmount = 0.3;
    }
}
