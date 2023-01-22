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
        nameCol.setMinWidth(((SCOREBOARD_WIDTH - 20) * 2) / 3);
        nameCol.setSortable(false);

        TableColumn<Player, String> scoreCol = new TableColumn<>("Score");
        scoreCol.setMinWidth((SCOREBOARD_WIDTH - 25) / 3);
        scoreCol.setSortable(false);


        //TODO make it prettier
        highScoreBoard.setSpacing(5);
        highScoreBoard.setPadding(new Insets(10, 10, 10, 10));
        highScoreBoard.getChildren().addAll(table);

        Player player1 = new Player("John", 100);
        Player player2 = new Player("Benni", 80);
        Player player3 = new Player("Alex", 20);
        List<Player> playerList = HighscoreService.getSavedPlayerList();

        final ObservableList<Player> data = FXCollections.observableArrayList(
                player1,
                player2,
                player3);

        data.addAll(playerList);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        nameCol.setStyle("-fx-alignment: CENTER;");
        scoreCol.setStyle("-fx-alignment: CENTER;");


        table.setItems(data);
        table.getColumns().addAll(nameCol, scoreCol);

    }
}
