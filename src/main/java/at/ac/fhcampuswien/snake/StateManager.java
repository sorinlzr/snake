package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.controller.GameboardViewController;
import at.ac.fhcampuswien.snake.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;
import static at.ac.fhcampuswien.snake.util.Constants.TITLE;

/**
 * This class is responsible for switching between the different views and managing the gameBoard state.
 */
public class StateManager {
    private static Stage stage = null;

    private static GameBoard gameBoard;

    public static void initializeStage(Stage stage) {
        StateManager.stage = stage;

        stage.setTitle(TITLE);
        stage.setResizable(false);
    }

    public static void switchToStartView() throws IOException {
        stopGameIfRunning();

        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("main-view.fxml"));
        Scene startScreen = new Scene(fxmlLoader.load(), SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setStage(stage);

        ImageView logo = mainViewController.getLogo();

        logo.fitWidthProperty().bind(stage.widthProperty());

        stage.setScene(startScreen);
        stage.show();
    }

    public static void switchToGameBoardView() throws IOException {
        FXMLLoader gameBoardViewFxmlLoader = new FXMLLoader(SnakeApp.class.getResource("gameboard-view.fxml"));
        Scene gameScreen = new Scene(gameBoardViewFxmlLoader.load(), SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);
        GameboardViewController gameboardViewController = gameBoardViewFxmlLoader.getController();
        gameboardViewController.setStage(stage);
        stage.setScene(gameScreen);

        Canvas gameBoardCanvas = gameboardViewController.getGameBoard();
        gameBoard = new GameBoard(gameBoardCanvas);
        gameBoard.startGame();

        gameScreen.getStylesheets().add("css/gameBoardView.css");

        stage.setOnCloseRequest(event -> {
            gameBoard.stopGame();
        });
    }

    private static void stopGameIfRunning() {
        if (gameBoard != null) {
            gameBoard.stopGame();
        }
    }
}
