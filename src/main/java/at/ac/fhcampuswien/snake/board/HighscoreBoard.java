package at.ac.fhcampuswien.snake.board;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import static at.ac.fhcampuswien.snake.util.Constants.SCOREBOARD_HEIGHT;
import static at.ac.fhcampuswien.snake.util.Constants.SCOREBOARD_WIDTH;

public class HighscoreBoard {

    private final TableView<String> table;

    private final VBox highScoreBoard;

    public HighscoreBoard(VBox vBox) {
        this.table = new TableView<>();
        this.highScoreBoard = vBox;
        this.highScoreBoard.setMaxWidth(SCOREBOARD_WIDTH);
        this.highScoreBoard.setMaxHeight(SCOREBOARD_HEIGHT);

        TableColumn<String, String> nameCol = new TableColumn<>("Name");
        TableColumn<String, String> scoreCol = new TableColumn<>("Score");

        table.getColumns().addAll(nameCol, scoreCol);

        //TODO make it prettier
        highScoreBoard.setSpacing(5);
        highScoreBoard.setPadding(new Insets(10, 10, 10, 10));
        highScoreBoard.getChildren().addAll(table);

    }
}
