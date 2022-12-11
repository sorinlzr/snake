package at.ac.fhcampuswien.snake.ingameobjects;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.snake.util.Constants.Direction;


//TODO implement DrawableObject
public class Snake {

    private int length;

    private boolean isAlive;
    private Direction direction;
    private final List<Position> segments = new ArrayList<>();

    public Snake(int initialSize, Direction initialDirection) {
        int initialLength = 0;
        Position initialPosition = new Position(9, 9);

        // TODO use KeyCode Enums instead of custom ones. KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT
        switch (initialDirection) {
            case UP -> {
                direction = Direction.UP;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX(), (initialPosition.getY()) + i));
                    initialLength++;
                }
            }
            case DOWN -> {
                direction = Direction.DOWN;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX(), initialPosition.getY() + i));
                    initialLength++;
                }
            }
            case LEFT -> {
                direction = Direction.LEFT;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX() + i, initialPosition.getY()));
                    initialLength++;
                }
            }
            case RIGHT -> {
                direction = Direction.RIGHT;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX() - i, initialPosition.getY()));
                    initialLength++;
                }
            }
        }
        this.length = initialLength;
        this.isAlive = true;
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    /**
     * This method updates the position of the snake
     * based on the current {@link Direction}
     * To sum up, it will:
     * - get current head {@link Position}
     * - calculate new position of head based on current direction
     * - replace current head with new head
     * - remove last segment of the snake
     */
    public void updateSnakePosition() {

        Position currentHead = segments.get(0);
        Position newHead = null;

        switch (this.direction) {
            case UP -> newHead = new Position(currentHead.getX(), currentHead.getY() - 1);
            case DOWN -> newHead = new Position(currentHead.getX(), currentHead.getY() + 1);
            case LEFT -> newHead = new Position(currentHead.getX() - 1, currentHead.getY());
            case RIGHT -> newHead = new Position(currentHead.getX() + 1, currentHead.getY());
        }

        segments.add(0, newHead);
        segments.remove(segments.size() - 1);
    }

}
