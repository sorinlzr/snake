package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.SnakeApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;
public class GameOverController {
    private Stage stage;
    private Scene scene;
    @FXML
    public Text scoreTextField;

    // TODO - Call this method, when the Gameboard Detects, that the Game is over!
    public void gameOverScreen(Stage stage, int score) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("gameover-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        scoreTextField.setText(String.valueOf(score));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void playNewGame(ActionEvent actionEvent) {
        // TODO Implement the Gameboard Class to start another Game.
    }

    public void goToSettings(ActionEvent actionEvent) {
        // TODO Check if there will be a Settings Menu in the Final Version
    }
}