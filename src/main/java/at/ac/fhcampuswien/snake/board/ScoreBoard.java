package at.ac.fhcampuswien.snake.board;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static at.ac.fhcampuswien.snake.util.Constants.*;
public class ScoreBoard {
    private GraphicsContext gc;
    private final Canvas scoreBoardCanvas;
    public ScoreBoard(Canvas scoreBoardCanvas){
        this.scoreBoardCanvas = scoreBoardCanvas;
        this.gc = scoreBoardCanvas.getGraphicsContext2D();
    }

    public void drawScoreBoard(int score){
        this.gc.setFill(Color.web("339933"));
        this.gc.fillRect(0,0, SCOREBOARD_WIDTH, SCOREBOARD_HEIGHT);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.setTextBaseline(VPos.CENTER);
        this.gc.setFill(Color.BLACK);
        this.gc.setFont(Font.font("Courier", OBJECT_SIZE_MEDIUM));
        this.gc.fillText( "Score: " + score, SCOREBOARD_WIDTH-7, SCOREBOARD_HEIGHT/2);
    }

    public GraphicsContext getGc(){return this.gc;}

}
