package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.SoundFX;

import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.snake.util.Constants.*;


public class Snake {

    private int length;
    private boolean positionUpdated;
    private boolean isAlive;
    private Direction direction;
    private final List<Position> segments = new ArrayList<>();

    public Snake(int initialSize, Direction initialDirection) {
        int initialLength = 0;
        Position initialPosition = new Position(GAME_BOARD_SIZE_MEDIUM / 2, GAME_BOARD_SIZE_MEDIUM / 2);

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

    /**
     * This method checks if the snakes goes out of the game area or if the head collides with the body segment.
     */
    public void checkForCollisions(Wall wall) {
        Position head = this.segments.get(0);

        // Checks if snake goes out of the game border.
        if (head.getX() < OBJECT_SIZE_MEDIUM || head.getX() >= GAME_BOARD_SIZE_MEDIUM - OBJECT_SIZE_MEDIUM ||
                head.getY() < OBJECT_SIZE_MEDIUM || head.getY() >= GAME_BOARD_SIZE_MEDIUM - OBJECT_SIZE_MEDIUM) {
            this.isAlive = false;
        }

        // Checks if snake collides with itself.
        for (int i = 1; i < this.length; i++) {
            if (head.getX() == segments.get(i).getX() && head.getY() == segments.get(i).getY()) {
                this.isAlive = false;
                break;
            }
        }

        // If there is an inner wall, checks if snake collides with the inner walls
        if (wall != null) {
            for (Position wallSegment : wall.getSegments()) {
                if (head.getX() == wallSegment.getX() && head.getY() == wallSegment.getY()) {
                    this.isAlive = false;
                    break;
                }
            }
        }
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public void eats(Food food) {
        if (food.isSpecialFood()) SoundFX.playBonusPointSound();
        else SoundFX.playEatingSound();
        length++;
        segments.add(new Position(-1, -1));
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
        this.positionUpdated = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isPositionUpdated() {
        return positionUpdated;
    }

    public void setPositionUpdated(boolean positionUpdated) {
        this.positionUpdated = positionUpdated;
    }
}
