package Controllers;

import Components.League;
import com.sun.javafx.image.impl.General;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/league?serverTimezone=UTC";

    private Connection connection;
    private GeneralController generalController;

    DatabaseController(GeneralController generalController) {
        try {
            this.generalController = generalController;
            this.connection = DriverManager.getConnection(DATABASE_URL, "root", "szklarz231");
            System.out.println("\n\n========== CONNECTION ESTABLISHED ===========\n\n");
        } catch (SQLException e) {
            System.out.println("\n\n========== CONNECTION ERROR ===========\n\n");

            e.printStackTrace();
        }
    }

    public ObservableList<League> loadLeagues() {

        ObservableList<League> leagueObservableList = FXCollections.emptyObservableList();
        String sql = "SELECT * FROM leagues";

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                byte[] bytes = resultSet.getBytes(2);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
                leagueObservableList.add((League) objectInputStream.readObject());
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return leagueObservableList;
    }

}
