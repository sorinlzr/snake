package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private final List<Position> segments = new ArrayList<>();

    /**
     * This Contructor creates the border walls.
     * It requires a orientation and the starting points after which
     * it will create wall till the edge of the screen in BLOCK_SIZE increments.
     * @param isHorizontal specifies if the horizontal or not Depending on this, one of the coordinates is constant.
     * @param startingPostionX The starting point of the wall on the X axis.
     * @param startingPostionY The starting point of the wall on the Y axis.
     */
    public Wall (boolean isHorizontal, int startingPostionX, int startingPostionY) {
        if (isHorizontal) {
            for (int i = startingPostionX; i < Constants.SCREEN_SIZE_MEDIUM; i += Constants.BLOCK_SIZE) {
                segments.add(new Position(startingPostionX + i * Constants.BLOCK_SIZE, startingPostionY) );
            }
        } else {
            for (int i = startingPostionY; i < Constants.SCREEN_SIZE_MEDIUM; i += Constants.BLOCK_SIZE) {
                segments.add(new Position(startingPostionX, startingPostionY + i * Constants.BLOCK_SIZE) );
            }
        }
    }

    public List<Position> getSegments() {
        return segments;
    }
}
