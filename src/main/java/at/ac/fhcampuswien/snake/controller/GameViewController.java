package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.util.StateManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.*;

public class GameViewController {

    protected Stage stage = null;

    @FXML
    private Canvas gameBoardCanvas;
    @FXML
    private Canvas scoreBoardCanvas;

    public void initialize() {
        this.gameBoardCanvas.setHeight(GAME_BOARD_SIZE_MEDIUM);
        this.gameBoardCanvas.setWidth(GAME_BOARD_SIZE_MEDIUM);
        this.scoreBoardCanvas.setWidth(SCOREBOARD_WIDTH);
        this.scoreBoardCanvas.setHeight(SCOREBOARD_HEIGHT);
    }

    public Canvas getGameBoardCanvas() {
        return this.gameBoardCanvas;
    }

    public Canvas getScoreBoardCanvas(){
        return this.scoreBoardCanvas;
    }

    @FXML
    public void returnToStartScreen() throws IOException {
        StateManager.switchToStartView();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
