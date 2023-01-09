package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.Food;
import at.ac.fhcampuswien.snake.ingameobjects.Position;
import at.ac.fhcampuswien.snake.ingameobjects.Snake;
import at.ac.fhcampuswien.snake.ingameobjects.Wall;
import javafx.application.Platform;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;

import static at.ac.fhcampuswien.snake.util.Constants.Direction.*;
import static at.ac.fhcampuswien.snake.util.Constants.*;
public class ScoreBoard {
    private GraphicsContext gc;
    private final Canvas scoreBoard;
    public ScoreBoard(Canvas scoreBoard){
        this.scoreBoard = scoreBoard;
    }

    public void drawScoreBoard(GraphicsContext gc){
        gc.setFill(Color.LIGHTSKYBLUE);
        gc.fillRect();
    }
}
