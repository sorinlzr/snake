package at.ac.fhcampuswien.snake.ingameobjects;

import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.snake.util.Constants.*;


//TODO implement DrawableObject
public class Snake {

    private int length;

    private boolean isAlive;
    private Direction direction;
    private final List<Position> segments = new ArrayList<>();

    public Snake(int initialSize, Direction initialDirection) {
        int initialLength = 0;
        Position initialPosition = new Position(SCREEN_SIZE_MEDIUM / 2, SCREEN_SIZE_MEDIUM / 2);

        // TODO use KeyCode Enums instead of custom ones. KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT
        switch (initialDirection) {
            case UP -> {
                direction = Direction.UP;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX(), (initialPosition.getY()) - i * OBJECT_SIZE_MEDIUM));
                    initialLength++;
                }
            }
            case DOWN -> {
                direction = Direction.DOWN;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX(), initialPosition.getY() + i * OBJECT_SIZE_MEDIUM));
                    initialLength++;
                }
            }
            case LEFT -> {
                direction = Direction.LEFT;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX() + i * OBJECT_SIZE_MEDIUM, initialPosition.getY()));
                    initialLength++;
                }
            }
            case RIGHT -> {
                direction = Direction.RIGHT;
                for (int i = 0; i < initialSize; i++) {
                    segments.add(new Position(initialPosition.getX() - i * OBJECT_SIZE_MEDIUM, initialPosition.getY()));
                    initialLength++;
                }
            }
        }
        this.length = initialLength;
        this.isAlive = true;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getSegments() {
        return segments;
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
            case UP -> newHead = new Position(currentHead.getX(), currentHead.getY() - OBJECT_SIZE_MEDIUM);
            case DOWN -> newHead = new Position(currentHead.getX(), currentHead.getY() + OBJECT_SIZE_MEDIUM);
            case LEFT -> newHead = new Position(currentHead.getX() - OBJECT_SIZE_MEDIUM, currentHead.getY());
            case RIGHT -> newHead = new Position(currentHead.getX() + OBJECT_SIZE_MEDIUM, currentHead.getY());
        }

        segments.add(0, newHead);
        segments.remove(segments.size() - 1);
    }

}
