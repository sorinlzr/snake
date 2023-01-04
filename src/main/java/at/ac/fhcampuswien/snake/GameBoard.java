package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.Position;
import at.ac.fhcampuswien.snake.ingameobjects.Snake;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

import static at.ac.fhcampuswien.snake.util.Constants.*;

public class GameBoard {

    private GraphicsContext gc;
    /**
     * The pane that is used to display the game board.
     */
    private final Canvas gameBoard;

    /**
     * A task which is executed by {@link #refreshGameBoardTimer}.
     */
    private final TimerTask refreshGameBoardTimerTask;

    /**
     * The timer which executes a {@link #refreshGameBoardTimerTask} every n milliseconds.
     */
    private final Timer refreshGameBoardTimer;

    /**
     * The snake, lol
     */
    private Snake snake;

    /**
     * The score of the current game.
     */
    private int score;

    /**
     * Constructor for GameBoard.
     * Requests focus for the game board, so that key events get recognized.
     *
     * @param gameBoard Pane to draw on
     */
    public GameBoard(Canvas gameBoard) {
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
        gameBoard.requestFocus();

        refreshGameBoardTimer.scheduleAtFixedRate(refreshGameBoardTimerTask, 0, 500);
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
        snake = new Snake(INITIAL_SIZE, INITIAL_DIRECTION);
        gc = gameBoard.getGraphicsContext2D();

        drawGameboard(gc);
        drawSnake(gc);
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

    private void drawSnake(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        Position head = snake.getSegments().get(0);
        gc.fillOval(head.getX(), head.getY(), OBJECT_SIZE_MEDIUM, OBJECT_SIZE_MEDIUM);

        gc.setFill(Color.GREEN);
        for (int i = 1; i < snake.getSegments().size(); i++) {
            Position bodySegment = snake.getSegments().get(i);
            gc.fillOval(bodySegment.getX(), bodySegment.getY(), OBJECT_SIZE_MEDIUM, OBJECT_SIZE_MEDIUM);
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
                case A -> {
                    snake.setDirection(Direction.UP);
                }
                case DOWN -> {
                    snake.setDirection(Direction.DOWN);
                }
                case LEFT -> {
                    snake.setDirection(Direction.LEFT);
                }
                case RIGHT -> {
                    snake.setDirection(Direction.RIGHT);
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
        snake.updateSnakePosition();
        drawGameboard(gc);
        drawSnake(gc);
    }
}
