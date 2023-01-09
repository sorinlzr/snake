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
import at.ac.fhcampuswien.snake.util.Constants;

import java.util.*;

import static at.ac.fhcampuswien.snake.util.Constants.Direction.*;
import static at.ac.fhcampuswien.snake.util.Constants.*;
public class ScoreBoard {
    private GraphicsContext gc;
    private final Canvas scoreBoardCanvas;
    public ScoreBoard(Canvas scoreBoardCanvas){
        this.scoreBoardCanvas = scoreBoardCanvas;
        this.gc = scoreBoardCanvas.getGraphicsContext2D();
    }

    public void drawScoreBoard(){
        gc.setFill(Color.RED);
        gc.fillRect(0,GAME_BOARD_SIZE_MEDIUM, SCOREBOARD_WIDTH, SCOREBOARD_HEIGHT);
    }

    public GraphicsContext getGc(){return this.gc;}

    public void updateScoreBoard(int newScore){
        // draw newSore on the Screen

    }
}
