package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.BoardObject;
import at.ac.fhcampuswien.snake.util.Constants;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard {

    private Pane gameBoard;

    private TimerTask autoRun;

    private Timer timer;

    // TODO implement Score somewhere. Here? Or should it be in Scoreboard? How should it be referenced?

    private BoardObject Snake;
    private List<BoardObject> boardObjects = new ArrayList<>();

    // TODO just for testing. Delete afterwards.
    private List<Rectangle> rectangles = new ArrayList<>();

    /**
     * Constructor for GameBoard.
     * Requests focus for the game board, so that key events get recognized.
     *
     * @param gameBoard Pane to draw on
     */
    public GameBoard(Pane gameBoard) {
        this.gameBoard = gameBoard;
        this.gameBoard.requestFocus();

        autoRun = new TimerTask() {
            @Override
            public void run() {
                update();
            }
        };
    }

    public void Run() {
        addBoardObjects();
        initializeEvents();

        timer = new Timer();
        timer.scheduleAtFixedRate(autoRun, 0, 200);
    }

    public void Stop() {
        timer.cancel();
    }

    private void addBoardObjects() {
        Rectangle rectangle = new Rectangle(0, 0, 10, 10);

        gameBoard.getChildren().add(rectangle);
        this.rectangles.add(rectangle);
    }

    private void initializeEvents() {
        gameBoard.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> {
                    throw new UnsupportedOperationException("Not implemented yet");
                }
                case DOWN -> {
                    throw new UnsupportedOperationException("Not implemented yet");
                }
                case LEFT -> {
                    throw new UnsupportedOperationException("Not implemented yet");
                }
                case RIGHT -> {
                    throw new UnsupportedOperationException("Not implemented yet");
                }
            }
        });
    }

    private void update() {
        for (Rectangle rectangle : this.rectangles) {
            if (rectangle.getX() >= Constants.SCREEN_SIZE_MEDIUM) {
                rectangle.setX(0);
            }else {
                rectangle.setX(rectangle.getX() + 10);
            }
        }
    }
}
