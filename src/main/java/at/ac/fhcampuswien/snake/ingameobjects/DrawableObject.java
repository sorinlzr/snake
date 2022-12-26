package at.ac.fhcampuswien.snake.ingameobjects;

import javafx.scene.paint.Color;

import java.util.List;

enum Type {
    POINTS,
    CHARACTER,
    OBSTACLE
}

public abstract class DrawableObject {
    public List<Position> positions;

    public Type type;

    public Color color;

    public DrawableObject(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public boolean doesIntersectsWith(DrawableObject other) {
        for (Position position : positions) {
            if (other.positions.contains(position)) {
                return true;
            }
        }

        return false;
    }
}
