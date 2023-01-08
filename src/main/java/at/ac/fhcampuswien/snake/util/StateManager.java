package at.ac.fhcampuswien.snake.util;

import at.ac.fhcampuswien.snake.GameBoard;
import at.ac.fhcampuswien.snake.SnakeApp;
import at.ac.fhcampuswien.snake.controller.GameboardViewController;
import at.ac.fhcampuswien.snake.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.*;

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
        Scene startScreen = new Scene(fxmlLoader.load(), APP_WIDTH_MEDIUM, APP_HEIGHT_MEDIUM);
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setStage(stage);

        startScreen.getStylesheets().add("css/mainView.css");

        ImageView logo = mainViewController.getLogo();

        logo.fitWidthProperty().bind(stage.widthProperty());

        stage.setScene(startScreen);
        stage.show();
    }

    public static void switchToGameBoardView() throws IOException {
        FXMLLoader gameBoardViewFxmlLoader = new FXMLLoader(SnakeApp.class.getResource("gameboard-view.fxml"));
        Scene gameScreen = new Scene(gameBoardViewFxmlLoader.load(), APP_WIDTH_MEDIUM, APP_HEIGHT_MEDIUM);
        GameboardViewController gameboardViewController = gameBoardViewFxmlLoader.getController();
        gameboardViewController.setStage(stage);
        stage.setScene(gameScreen);

        Canvas gameBoardCanvas = gameboardViewController.getGameBoard();
        gameBoard = new GameBoard(gameBoardCanvas);
        gameBoard.startGame();

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
