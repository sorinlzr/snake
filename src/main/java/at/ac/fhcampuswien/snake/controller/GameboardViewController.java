package at.ac.fhcampuswien.snake.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;

public class GameboardViewController {

    @FXML
    private Canvas gameBoard;

    public void initialize() {
        this.gameBoard.setHeight(SCREEN_SIZE_MEDIUM);
        this.gameBoard.setWidth(SCREEN_SIZE_MEDIUM);
    }

    public Canvas getGameBoard(){
        return this.gameBoard;
    }
}
