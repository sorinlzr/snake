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
    private VBox body;

    @FXML
    private VBox footer;

    public void initialize() {
        this.gameBoard.setHeight(GAME_BOARD_SIZE_MEDIUM);
        this.gameBoard.setWidth(GAME_BOARD_SIZE_MEDIUM);

        body.setVgrow(footer, javafx.scene.layout.Priority.ALWAYS);
        footer.setAlignment(javafx.geometry.Pos.CENTER);
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
