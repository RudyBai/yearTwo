import Controllers.GeneralController;
import GUI.ListLeagues;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        GeneralController generalController = new GeneralController();

        TabPane tabPane = new TabPane();

        ListLeagues listLeagues = new ListLeagues(generalController);

        tabPane.getTabs().add(listLeagues);

        // Show window with TabPane
        Scene scene = new Scene(tabPane, 450, 500);
        tabPane.setId("pane");


        stage.setScene(scene);
        stage.show();

    }
}
