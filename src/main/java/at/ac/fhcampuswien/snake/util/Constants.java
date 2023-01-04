package at.ac.fhcampuswien.snake.util;

public class Constants {

    public static final String TITLE = "Snake";
    public static final int SCREEN_SIZE_MEDIUM = 500;
    public static final int NUMBER_OF_ROWS_AND_COLS = 20;
    public static final int OBJECT_SIZE_MEDIUM = SCREEN_SIZE_MEDIUM/NUMBER_OF_ROWS_AND_COLS;

    public static final String GAMEBOARD_COLOR_LIGHT = "FFCC66";
    public static final String GAMEBOARD_COLOR_DARK = "CC9933";

    public final static int INITIAL_SIZE = 4;
    public final static Direction INITIAL_DIRECTION = Direction.RIGHT;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public enum Type {
        POINTS, CHARACTER, OBSTACLE
    }

}
