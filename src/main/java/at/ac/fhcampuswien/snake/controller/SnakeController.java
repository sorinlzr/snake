package at.ac.fhcampuswien.snake.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnakeController {

    private static final Logger LOG = LoggerFactory.getLogger(SnakeController.class);

    private boolean showText = false;

    @FXML
    private Label textBox;

    @FXML
    private ImageView logo;

    @FXML
    private Canvas gameBoard;

    public void initialize() {
        Image logo = new Image("snake_logo.jpg");
        this.logo.setImage(logo);
        this.logo.setPreserveRatio(true);
        this.logo.setSmooth(true);

        this.textBox.setText("\n\n");

        this.gameBoard.setWidth(20);
        this.gameBoard.setHeight(20);
    }

    @FXML
    public void onImplementMeButtonClick() {
        if (!showText) {
            this.showText = true;
            this.textBox.setText("If you see this, it means \nthat at least it's working so far :)");
            LOG.info("Implement me button clicked");
        } else {
            this.showText = false;
            this.textBox.setText("\n\n");
        }
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

    @FXML
    public void onExitButtonClick() {
        Platform.exit();
    }

    public ImageView getLogo() {
        return this.logo;
    }

    public Canvas getGameBoard(){
        return this.gameBoard;
    }
}