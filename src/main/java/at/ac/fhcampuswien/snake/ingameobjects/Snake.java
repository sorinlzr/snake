package at.ac.fhcampuswien.snake.ingameobjects;

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

}
