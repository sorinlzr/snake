package at.ac.fhcampuswien.snake.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;

public class GameboardViewController {

    @FXML
    private Pane gameBoard;

    public void initialize() {
        this.gameBoard.setMaxWidth(SCREEN_SIZE_MEDIUM);
        this.gameBoard.setMaxHeight(SCREEN_SIZE_MEDIUM);
        this.gameBoard.setMinWidth(SCREEN_SIZE_MEDIUM);
        this.gameBoard.setMinHeight(SCREEN_SIZE_MEDIUM);
    }

    public Pane getGameBoard(){
        return this.gameBoard;
    }
}
