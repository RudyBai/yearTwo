import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.Collections;

import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;

/**
 * main runs at launch to create stage and panes.
 */
public class main extends Application {
    /**
     * start is required by Application and runs the program.
     * TabPane is created with its Panes; carTab and carListTab.
     * carTabController constructor takes both tabs in its constructor,
     * and therefore has to be set after the panes are created.
     * @param primaryStage main window
     */
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Cars");

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(UNAVAILABLE);
        CarTab carTab = new CarTab();
        CarListTab carListTab = new CarListTab();
        tabPane.getTabs().addAll(carTab, carListTab);

        carTab = (CarTab) tabPane.getTabs().get(0);
        carTab.setCarTabController(new CarTabController(carTab));

        carListTab = (CarListTab) tabPane.getTabs().get(1);
        carListTab.setCarListTabController(new CarListTabController(carListTab));

        Scene scene = new Scene(tabPane, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
