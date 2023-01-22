package at.ac.fhcampuswien.snake.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HighscoreController {

    public ImageView logo;

    @FXML
    private Label textBox;
    @FXML
    private VBox highScoreTable;


    protected Stage stage = null;

    public void initialize () {
        Image logo = new Image("graphics/snake_logo.jpg");
        this.logo.setImage(logo);
        this.logo.setPreserveRatio(true);
        this.logo.setSmooth(true);
        this.textBox.setText("Highscores");
        this.textBox.setFont(new Font("Arial", 20));

    }

    @FXML
    public void showInfoDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText(
                """
                        Awesome Snake game
                        Courtesy of PurplePain™
                        """);
        alert.showAndWait();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ImageView getLogo() {
        return this.logo;
    }

    public VBox getHighScoreTable() {
        return highScoreTable;
    }
}
