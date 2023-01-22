package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.util.StateManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameOverController {

    @FXML
    private Text scoreTextField;

    @FXML
    private VBox highScoreTable;


    public void playNewGame(ActionEvent actionEvent) throws IOException {
        StateManager.switchToGameView();
    }

    public void goToMainMenu(ActionEvent actionEvent) throws IOException {
        StateManager.switchToStartView();
    }


    public void setScoreTextField(String score) {
        this.scoreTextField.setText(score);
    }


    public VBox getHighScoreTable() {
        return highScoreTable;
    }
}