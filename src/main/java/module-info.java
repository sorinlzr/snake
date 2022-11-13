module at.ac.fhcampuswien.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.ac.fhcampuswien.snake to javafx.fxml;
    exports at.ac.fhcampuswien.snake;
    exports at.ac.fhcampuswien.snake.controller;
    opens at.ac.fhcampuswien.snake.controller to javafx.fxml;
    exports at.ac.fhcampuswien.snake.util;
    opens at.ac.fhcampuswien.snake.util to javafx.fxml;
}