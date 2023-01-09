package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.util.StateManager;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class SnakeApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        StateManager.initializeStage(stage);
        StateManager.switchToStartView();
    }

    public static void main(String[] args) {
        launch();
    }
}