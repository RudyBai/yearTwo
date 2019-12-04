import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class main extends Application {

    public void start(Stage stage) {

        // General Controller
        GeneralController generalController = new GeneralController();

        // Tab Pane
        TabPane tabPane = new TabPane();

        // Instantiate Tabs
        GuessingGame guessingGame = new GuessingGame(generalController);
        LottoCure lottoCure = new LottoCure(generalController);
        PrizesTab prizesTab = new PrizesTab(generalController.getListView(), generalController);

        // Remove Close Button From Tabs
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Add Tabs to TabPane
        tabPane.getTabs().addAll(guessingGame, lottoCure, prizesTab);

        // Stage and Scene Setup
        Scene scene = new Scene(tabPane, 400, 400);
        stage.setTitle("Games");
        stage.setScene(scene);
        stage.show();
    }
}