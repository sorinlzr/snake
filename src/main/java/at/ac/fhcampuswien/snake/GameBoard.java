package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.BoardObject;
import at.ac.fhcampuswien.snake.util.Constants;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard {

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
    public void startGame() {
        initializeBoardObjects();
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
    private void initializeBoardObjects() {
        // The rectangle is still for testing purposes. We will use BoardObjects instead.

        // Creates a rectangle. The coordinates will be in relative pixel distance to the Pane.
        Rectangle rectangle = new Rectangle(0, 0, 10, 10);

        // Fill the rectangle with an image.
        Image img = new Image("/fruits/apple.png");
        rectangle.setFill(new ImagePattern(img));

        // This draws objects on the pane. If you do this, you can see them on the gameBoard.
        gameBoard.getChildren().add(rectangle);

        // Adds a rectangle to the list which manages all rectangles in the background.
        this.rectangles.add(rectangle);

        for (int i = 0; i < boardObjects.length; i++) {
            for (int j = 0; j < boardObjects[i].length; j++) {
                // TODO initialize the walls here.
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
        // The rectangle is still for testing purposes. We will use BoardObjects instead.
        for (Rectangle rectangle : this.rectangles) {
            if (rectangle.getX() >= Constants.SCREEN_SIZE_MEDIUM) {
                rectangle.setX(0);
            }else {
                rectangle.setX(rectangle.getX() + 10);
            }
        }
    }
}
