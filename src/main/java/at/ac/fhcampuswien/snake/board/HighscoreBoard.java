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

import static at.ac.fhcampuswien.snake.util.Constants.HIGHSCORE_BOARD_HEIGHT;
import static at.ac.fhcampuswien.snake.util.Constants.HIGHSCORE_BOARD_WIDTH;
import static at.ac.fhcampuswien.snake.util.Constants.HIGHSCORE_BOARD_NAME_COL_WIDTH;
import static at.ac.fhcampuswien.snake.util.Constants.HIGHSCORE_BOARD_SCORE_COL_WIDTH;

public class HighscoreBoard {

    public HighscoreBoard(VBox vBox) {
        TableView<Player> table = new TableView<>();
        vBox.setMaxHeight(HIGHSCORE_BOARD_HEIGHT);
        vBox.setMaxWidth(HIGHSCORE_BOARD_WIDTH);

        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMinWidth(HIGHSCORE_BOARD_NAME_COL_WIDTH);
        nameCol.setSortable(false);
        nameCol.setReorderable(false);

        TableColumn<Player, String> scoreCol = new TableColumn<>("Score");
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreCol.setMinWidth((HIGHSCORE_BOARD_SCORE_COL_WIDTH));
        scoreCol.setSortable(false);
        scoreCol.setReorderable(false);

        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(table);

        final List<Player> playerList = HighscoreService.getSavedPlayerList();
        final ObservableList<Player> data = FXCollections.observableArrayList(playerList);

        nameCol.setStyle("-fx-alignment: CENTER;");
        scoreCol.setStyle("-fx-alignment: CENTER;");

        table.setItems(data);
        table.getColumns().addAll(nameCol, scoreCol);

    }
}
