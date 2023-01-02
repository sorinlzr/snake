package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.controller.GameboardViewController;
import at.ac.fhcampuswien.snake.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;
import static at.ac.fhcampuswien.snake.util.Constants.TITLE;

public class SnakeApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("main-view.fxml"));
        Scene startScreen = new Scene(fxmlLoader.load(), SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);
        MainViewController mainViewController = fxmlLoader.getController();
        mainViewController.setStage(stage);


        startScreen.getStylesheets().add("css/app.css");
        ImageView logo = mainViewController.getLogo();

        logo.fitWidthProperty().bind(stage.widthProperty());

        stage.setTitle(TITLE);
        stage.setScene(startScreen);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}