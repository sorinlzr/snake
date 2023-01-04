package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.BoardObject;
import at.ac.fhcampuswien.snake.util.Constants;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static at.ac.fhcampuswien.snake.util.Constants.OBJECT_SIZE_MEDIUM;
import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;
import static at.ac.fhcampuswien.snake.util.Constants.GAMEBOARD_COLOR_DARK;
import static at.ac.fhcampuswien.snake.util.Constants.GAMEBOARD_COLOR_LIGHT;

public class GameBoard {

    private GraphicsContext gc;
    /**
     * The pane that is used to display the game board.
     */
    private final Pane gameBoard;

    /**
     * A task which is executed by {@link #refreshGameBoardTimer}.
     */
    private final TimerTask refreshGameBoardTimerTask;

    /**
     * The timer which executes a {@link #refreshGameBoardTimerTask} every n milliseconds.
     */
    private final Timer refreshGameBoardTimer;

    // TODO: I don't know if the snake should be an extra object or not.
    //  Maybe it should just be the head which is tracked here.
    //  We definitely need to track the head for collision detection let the other parts of the snake
    //  move the same way as the head.
    private BoardObject Snake;

    /**
     * An array of all {@link BoardObject}s that are currently on the game board.
     * The array manages the background logic of the game objects.
     */
    private BoardObject[][] boardObjects;

    /**
     * The score of the current game.
     */
    private int score;

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

        this.score = 0;

        refreshGameBoardTimerTask = new TimerTask() {
            @Override
            public void run() {
                refreshGameBoard();
            }
        };

        refreshGameBoardTimer = new Timer();

        int segmentsPerSide = Constants.SCREEN_SIZE_MEDIUM / Constants.OBJECT_SIZE_MEDIUM;
        boardObjects = new BoardObject[segmentsPerSide][segmentsPerSide];
    }

    /**
     * Starts a new game and a timer to refresh the game board.
     * <p>
     * It is important to call the {@link #stopGame()} method when the game is over,
     * so that the timer does not continue to run in the background.
     */
    public void startGame(Stage stage) {
        initializeBoardObjects(stage);
        initializeEvents();

        refreshGameBoardTimer.scheduleAtFixedRate(refreshGameBoardTimerTask, 0, 200);
    }

    /**
     * Stops the timer which refreshes the game board.
     */
    public void stopGame() {
        refreshGameBoardTimer.cancel();
    }

    /**
     * Add objects which should be part of the game here.
     *
     */
    private void initializeBoardObjects(Stage stage) {
        Canvas canvas = new Canvas(SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);
        Group root = new Group();
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        drawGameboard(gc);
        for (int i = 0; i < boardObjects.length; i++) {
            for (int j = 0; j < boardObjects[i].length; j++) {
                // TODO initialize the walls here.
            }
        }
    }

    /**
     * Method to draw the checkerboard pattern on the GraphicsContext
     * @param gc GraphicsContext gc used for all BoardObjects
     */
    private void drawGameboard(GraphicsContext gc) {
        for (int i = 0; i < SCREEN_SIZE_MEDIUM; i++) {
            for (int j = 0; j < SCREEN_SIZE_MEDIUM; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web(GAMEBOARD_COLOR_LIGHT));
                } else {
                    gc.setFill(Color.web(GAMEBOARD_COLOR_DARK));
                }
                gc.fillRect(i * OBJECT_SIZE_MEDIUM, j * OBJECT_SIZE_MEDIUM, OBJECT_SIZE_MEDIUM, OBJECT_SIZE_MEDIUM);
            }
        }
    }

    /**
     * Initializes javafx events.
     *
     * javafx events are events which are triggered by the user.
     * For example a button click or a key press.
     */
    private void initializeEvents() {
        // Checkout https://www.w3schools.com/java/java_lambda.asp for more information about lambdas.
        // Basically the event gets passed as a parameter and can be used inside the parentheses.
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

    /**
     * Here happens everything that needs a refresh.
     * For example the movement of the snake or collision detection.
     * <p>
     * The method is automatically called by a timer after n milliseconds.
     */
    private void refreshGameBoard() {

    }
}
