package at.ac.fhcampuswien.snake.util;

import at.ac.fhcampuswien.snake.SnakeApp;
import at.ac.fhcampuswien.snake.board.GameBoard;
import at.ac.fhcampuswien.snake.board.HighscoreBoard;
import at.ac.fhcampuswien.snake.board.ScoreBoard;
import at.ac.fhcampuswien.snake.controller.GameOverController;
import at.ac.fhcampuswien.snake.controller.GameViewController;
import at.ac.fhcampuswien.snake.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.*;

/**
 * This class is responsible for switching between the different views and managing the gameBoard state.
 */
public class StateManager {
    private static Stage stage = null;

    public static Difficulty difficulty = Difficulty.MEDIUM;

    private static GameBoard gameBoard;

    private static ScoreBoard scoreBoard;

    private static HighscoreBoard highscoreBoard;

    public static ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public static void initializeStage(Stage stage) {
        StateManager.stage = stage;

        stage.setTitle(TITLE);
        stage.setResizable(false);
    }

    public static void switchToStartView() throws IOException {
        stopGameIfRunning();

        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("main-view.fxml"));
        Scene startScreen = new Scene(fxmlLoader.load(), APP_WIDTH_MEDIUM, APP_HEIGHT_MEDIUM);
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setStage(stage);

        startScreen.getStylesheets().add("css/mainView.css");

        ImageView logo = mainViewController.getLogo();

        logo.fitWidthProperty().bind(stage.widthProperty());

        stage.setScene(startScreen);
        stage.show();
    }
    public static void switchToGameOverView() throws IOException {
        stopGameIfRunning();

        FXMLLoader gameOverViewFxmlLoader = new FXMLLoader(SnakeApp.class.getResource("gameover-view.fxml"));
        Scene gameOverScreen = new Scene(gameOverViewFxmlLoader.load(), APP_WIDTH_MEDIUM, APP_HEIGHT_MEDIUM);
        GameOverController gameOverController = gameOverViewFxmlLoader.getController();
        gameOverController.setScoreTextField(String.valueOf(gameBoard.getScore()));

        VBox highScoreVBox = gameOverController.getHighScoreTable();
        highscoreBoard = new HighscoreBoard(highScoreVBox);

        stage.setScene(gameOverScreen);
        stage.show();
    }

    public static void switchToGameView() throws IOException {
        FXMLLoader gameBoardViewFxmlLoader = new FXMLLoader(SnakeApp.class.getResource("game-view.fxml"));
        Scene gameScreen = new Scene(gameBoardViewFxmlLoader.load(), APP_WIDTH_MEDIUM, APP_HEIGHT_MEDIUM);
        GameViewController gameViewController = gameBoardViewFxmlLoader.getController();
        gameViewController.setStage(stage);
        stage.setScene(gameScreen);
        Canvas gameBoardCanvas = gameViewController.getGameBoardCanvas();
        Canvas scoreBoardCanvas = gameViewController.getScoreBoardCanvas();
        scoreBoard = new ScoreBoard(scoreBoardCanvas);
        gameBoard = new GameBoard(gameBoardCanvas, difficulty);
        gameBoard.startGame();

        stage.setOnCloseRequest(event -> gameBoard.stopAnimation());
    }

    private static void stopGameIfRunning() {
        if (gameBoard != null) {
            gameBoard.stopAnimation();
        }
    }
}
