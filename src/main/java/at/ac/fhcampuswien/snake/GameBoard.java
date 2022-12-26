package at.ac.fhcampuswien.snake;

import at.ac.fhcampuswien.snake.ingameobjects.DrawableObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.List;

public class GameBoard {

    private Canvas gameBoard;

    // TODO implement Score somewhere. Here? Or should it be in Scoreboard? How should it be referenced?

    private List<DrawableObject> objects;

    private boolean doesNeedRedraw = true;

    public GameBoard(Canvas gameBoard) {
        this.gameBoard = gameBoard;

        initializeEvents();
    }

    private void initializeEvents() {
        // TODO Events does not fire.
        this.gameBoard.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case UP -> {
                    System.out.println("UP");
                    doesNeedRedraw = true;
                }
                case DOWN -> {
                    System.out.println("DOWN");
                    doesNeedRedraw = true;
                }
                case LEFT -> {
                    System.out.println("LEFT");
                    doesNeedRedraw = true;
                }
                case RIGHT -> {
                    System.out.println("RIGHT");
                    doesNeedRedraw = true;
                }
            }
        });
    }

    public void playGame(){
        boolean gameOver = false;
        // TODO -> how to loop the game?
//        while (!gameOver){
            if (doesNeedRedraw){
                drawGameBoard();
                doesNeedRedraw = false;
            }
//        }
    }

    private void drawGameBoard(){
        // TODO draw positions of drawable objects here.
        // TODO check for snake collision.
        GraphicsContext gc = this.gameBoard.getGraphicsContext2D();

        gc.setStroke(Color.RED);
        gc.moveTo(0, 0);
        gc.lineTo(100, 100);
        gc.stroke();

//        throw new UnsupportedOperationException("Not implemented yet");
    }


}
