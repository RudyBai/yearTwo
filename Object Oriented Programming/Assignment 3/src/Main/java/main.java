import Controllers.School;
import GUI.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;

public class main extends Application {

    @Override
    public void start(Stage stage) {
        // Create School Object which acts as General Controller
        School school = new School(stage);

        // Create TabPane
        TabPane tabPane = new TabPane();

        // Add tabs to TabPane
        tabPane.getTabs().add(new MainMenu(school));
        // Set tabs to not be able to be closed
        tabPane.setTabClosingPolicy(UNAVAILABLE);

        // Show window with TabPane
        Scene scene = new Scene(tabPane, 450, 500);
        tabPane.setId("pane");

        stage.setOnCloseRequest(event -> school.close());

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}