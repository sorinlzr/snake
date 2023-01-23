package at.ac.fhcampuswien.snake.board;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static at.ac.fhcampuswien.snake.util.Constants.*;

public class ScoreBoard {
    private final GraphicsContext gc;

    public ScoreBoard(Canvas scoreBoardCanvas) {
        this.gc = scoreBoardCanvas.getGraphicsContext2D();
    }

    public void drawScoreBoard(int score) {
        this.gc.setFill(Color.web("4a148c"));
        this.gc.fillRect(0, 0, SCOREBOARD_WIDTH, SCOREBOARD_HEIGHT);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.setTextBaseline(VPos.CENTER);
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(Font.font("Courier", OBJECT_SIZE_MEDIUM));
        this.gc.fillText("Score: " + score, SCOREBOARD_WIDTH - 7, SCOREBOARD_HEIGHT / 2);
    }

    public void drawCountdownTimer() {
        int duration = 3;
        Text timerText = new Text(10, 20, Integer.toString(duration));

        Thread timerThread = new Thread(() -> {
            for (int i = duration; i >= 0; i--) {
                int finalI = i;
                Platform.runLater(() -> {
                    this.gc.setFill(Color.web("4a148c"));
                    this.gc.fillRect(0, 0, SCOREBOARD_WIDTH / 2, SCOREBOARD_HEIGHT);
                    if (finalI > 0) {
                        this.gc.setTextAlign(TextAlignment.LEFT);
                        this.gc.setTextBaseline(VPos.CENTER);
                        this.gc.setFill(Color.WHITE);
                        this.gc.setFont(Font.font("Courier", OBJECT_SIZE_MEDIUM));

                        timerText.setText("Starting in: " + finalI);
                        this.gc.fillText(timerText.getText(), 7, SCOREBOARD_HEIGHT / 2);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timerThread.start();
    }

}
