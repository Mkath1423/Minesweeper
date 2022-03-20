package minesweeper;

import engine.rendering.color.Color;

public final class Constants {
    public static final class kTile{

        public static float boarderPercent = 0.7f;

        public static Color boarderColor = new Color(0.3f, 0.3f, 0.3f, 1f);
        public static Color innerColor   = new Color(0.7f, 0.7f, 0.7f, 1f);

        public static float length = 15;

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
        public static int xSize = 10;
        public static int ySize = 15;

        public static final double easyBombsAmount = 0.1;
        public static final double mediumBombsAmount = 0.2;
        public static final double hardBombsAmount = 0.3;
    }
}
