package at.ac.fhcampuswien.snake.board;

import at.ac.fhcampuswien.snake.service.HighscoreService;
import at.ac.fhcampuswien.snake.util.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

import static at.ac.fhcampuswien.snake.util.Constants.SCOREBOARD_WIDTH;

public class HighscoreBoard {

    private final TableView<Player> table;

    private final VBox highScoreBoard;

    public HighscoreBoard(VBox vBox) {
        this.table = new TableView<>();
        this.highScoreBoard = vBox;
        this.highScoreBoard.setMaxWidth(SCOREBOARD_WIDTH);
        this.highScoreBoard.setMaxHeight(200);

        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth((SCOREBOARD_WIDTH - 140));
        nameCol.setSortable(false);
        nameCol.setReorderable(false);

        TableColumn<Player, String> scoreCol = new TableColumn<>("Score");
        scoreCol.setMinWidth((100));
        scoreCol.setSortable(false);
        scoreCol.setReorderable(false);


        //TODO make it prettier
        highScoreBoard.setSpacing(5);
        highScoreBoard.setPadding(new Insets(10, 10, 10, 10));
        highScoreBoard.getChildren().addAll(table);

        Player player1 = new Player("John", 100);

        HighscoreService.savePlayerHighscore(player1);
        List<Player> playerList = HighscoreService.getSavedPlayerList();

        final ObservableList<Player> data = FXCollections.observableArrayList(playerList);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        nameCol.setStyle("-fx-alignment: CENTER;");
        scoreCol.setStyle("-fx-alignment: CENTER;");


        table.setItems(data);
        table.getColumns().addAll(nameCol, scoreCol);

    }
}
