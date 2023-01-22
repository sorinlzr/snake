package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.util.StateManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameOverController {

    @FXML
    private Text scoreTextField;

    @FXML
    private Label textBox;
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

    public void initialize () {
        this.textBox.setText("Highscores");
        this.textBox.setFont(new Font("Arial", 20));
    }

    public VBox getHighScoreTable() {
        return highScoreTable;
    }
}