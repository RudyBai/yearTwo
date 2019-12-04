package GUI;

import Components.League;
import Controllers.GeneralController;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class ListLeagues extends Tab {

    private ListView<League> leagueListView;

    public ListLeagues(GeneralController generalController) {

        GridPane gridPane = new GridPane();

        this.leagueListView = new ListView<>(generalController.getLeagueObservableList());

        gridPane.add(leagueListView, 0, 0);

        this.setText("League List");

        gridPane                            .setHgap(10);
        gridPane                            .setVgap(10);
        gridPane                            .setAlignment(Pos.CENTER);

        this.setContent(gridPane);
    }

}
