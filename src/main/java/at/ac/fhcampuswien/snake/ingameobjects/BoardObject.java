package at.ac.fhcampuswien.snake.ingameobjects;

import at.ac.fhcampuswien.snake.util.Constants;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public abstract class BoardObject extends Rectangle{

    /**
     * The width and height of an object.
     * All objects are squares.
     */
    static final int DRAW_SIZE = Constants.OBJECT_SIZE_MEDIUM;

    /**
     * The type of object. Indicates if it is friendly, deadly or something else.
     */
    public Constants.Type type;

    public BoardObject(Constants.Type type, int x, int y) {
        this.type = type;

        this.setX(x);
        this.setY(y);
        this.setWidth(DRAW_SIZE);
        this.setHeight(DRAW_SIZE);
    }
}
