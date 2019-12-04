package Controllers;

import Components.League;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class GeneralController {

    private DatabaseController databaseController;
    private ObservableList<League> leagueObservableList;

    public GeneralController() {
        this.databaseController = new DatabaseController(this);
        this.leagueObservableList = loadLeagues();
    }

    private ObservableList<League> loadLeagues() {
        return databaseController.loadLeagues();
    }

    public DatabaseController getDatabaseController() {
        return databaseController;
    }

    public ObservableList<League> getLeagueObservableList() {
        return leagueObservableList;
    }

    public void setLeagueObservableList(ObservableList<League> leagueObservableList) {
        this.leagueObservableList = leagueObservableList;
    }
}
