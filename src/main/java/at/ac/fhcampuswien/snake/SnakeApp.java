package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.controller.SnakeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static at.ac.fhcampuswien.snake.util.Constants.SCREEN_SIZE_MEDIUM;
import static at.ac.fhcampuswien.snake.util.Constants.TITLE;

public class SnakeApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), SCREEN_SIZE_MEDIUM, SCREEN_SIZE_MEDIUM);

        SnakeController controller = fxmlLoader.getController();
        ImageView logo = controller.getLogo();

        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        logo.fitWidthProperty().bind(stage.widthProperty());
    }

    public static void main(String[] args) {
        launch();
    }
}