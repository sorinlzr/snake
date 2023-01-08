package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.util.StateManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.GAME_BOARD_SIZE_MEDIUM;

public class GameboardViewController {

    protected Stage stage = null;

    @FXML
    private Canvas gameBoard;

    public void initialize() {
        this.gameBoard.setHeight(GAME_BOARD_SIZE_MEDIUM);
        this.gameBoard.setWidth(GAME_BOARD_SIZE_MEDIUM);
    }

    public Canvas getGameBoard() {
        return this.gameBoard;
    }

    @FXML
    public void returnToStartScreen() throws IOException {
        StateManager.switchToStartView();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
