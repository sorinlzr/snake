package at.ac.fhcampuswien.snake.controller;

import at.ac.fhcampuswien.snake.GameBoard;
import at.ac.fhcampuswien.snake.SnakeApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;

public class MainViewController {

    private static final Logger LOG = LoggerFactory.getLogger(MainViewController.class);

    private boolean showText = false;

    protected Stage stage = null;
    @FXML
    private Label textBox;

    @FXML
    private ImageView logo;

    public void initialize() {
        Image logo = new Image("graphics/snake_logo.jpg");
        this.logo.setImage(logo);
        this.logo.setPreserveRatio(true);
        this.logo.setSmooth(true);
        this.textBox.setText("\n\n");
    }

    /**
     * Method that shall be triggered at the click of a button.
     * Creates a new Scene based on the fxml-file loaded.
     * Sets the Scene on the stage.
     * Creates a new GameBoard object.
     * Starts the game on that gameBoard.
     * @throws IOException
     */
    @FXML
    public void startGame() throws IOException {
        FXMLLoader gameBoardViewFxmlLoader = new FXMLLoader(SnakeApp.class.getResource("gameboard-view.fxml"));
        Scene gameScreen = new Scene(gameBoardViewFxmlLoader.load(), SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);
        GameboardViewController gameboardViewController = gameBoardViewFxmlLoader.getController();
        stage.setScene(gameScreen);
        Canvas gameBoardPane = gameboardViewController.getGameBoard();
        GameBoard gameBoard = new GameBoard(gameBoardPane);
        gameBoard.startGame(stage);

        stage.setOnCloseRequest(event -> {
            gameBoard.stopGame();
        });
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

    public void setStage(Stage stage){
        this.stage=stage;
    }
}