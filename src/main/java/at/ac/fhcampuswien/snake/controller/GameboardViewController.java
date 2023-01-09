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
    @FXML
    private Canvas scoreBoard;

    public void initialize() {
        this.gameBoard.setHeight(GAME_BOARD_SIZE_MEDIUM);
        this.gameBoard.setWidth(GAME_BOARD_SIZE_MEDIUM);
        this.scoreBoard.setHeight(SCREEN_SIZE_MEDIUM/10);
        this.scoreBoard.setWidth(SCREEN_SIZE_MEDIUM);
        this.scoreBoard.setLayoutX(0);
        this.scoreBoard.setLayoutY(SCREEN_SIZE_MEDIUM);
    }

    public Canvas getGameBoard() {
        return this.gameBoard;
    }

    public Canvas getScoreBoard(){ return this.scoreBoard; }

    @FXML
    public void returnToStartScreen() throws IOException {
        StateManager.switchToStartView();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
