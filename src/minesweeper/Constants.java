package minesweeper;

import engine.rendering.color.Color;

public final class Constants {
    public static final class kTile{
        public static float boarderPercent = 0.7f;

        public static Color boarderColor = new Color(0.3f, 0.3f, 0.3f, 1f);
        public static Color innerColor   = new Color(0.7f, 0.7f, 0.7f, 1f);

        public static float length = 15;
    }

    public static final class kGame{
        public static int xSize = 5;
        public static int ySize = 10;
    }
}
