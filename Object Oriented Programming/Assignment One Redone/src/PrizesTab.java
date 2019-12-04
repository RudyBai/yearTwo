import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class PrizesTab extends Tab {
    private GeneralController generalController;
    private Button buttonSelect;

    PrizesTab(ListView<String> listView, GeneralController generalController) {

        // General Controller
        this.generalController = generalController;
        // Set Title
        this.setText("Prizes Tab");

        // Instantiate Elements
        this.buttonSelect = new Button("Select");
        Button buttonQuit = new Button("Quit");
        Label label = new Label("Select a Prize!");

        // Instantiate GridPane
        GridPane gridPane = new GridPane();

        // gridPaneThree Content
        gridPane.add(listView, 0, 1, 3, 5);
        gridPane.add(label, 0, 0, 5, 1);
        gridPane.add(buttonSelect, 5, 3);
        gridPane.add(buttonQuit, 5, 4);

        // gridPaneThree Layout
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setHgap(10);

        // Set Content
        this.setContent(gridPane);

        // ======================
        // === Event Handlers ===
        // ======================

        // Button Select
        buttonSelect.setOnAction(event -> {
            if (event.getSource() == buttonSelect) {
                buttonSelect(listView);
            }
            generalController.refreshList((Stage) this.getTabPane().getScene().getWindow());
        });

        // Button Two Quit
        buttonQuit.setOnAction(event -> ((Stage) this.getTabPane().getScene().getWindow()).close());
    }

    private void buttonSelect(ListView listView) {
        String boxString = (String) listView.getSelectionModel().getSelectedItem();
        System.out.println(boxString);
        int cost = Integer.parseInt(generalController.getPrizeHashMap().get(boxString)[0]);
        System.out.println(cost);
        Alert prizeSelect = new Alert(Alert.AlertType.INFORMATION);
        if (generalController.getStars() < cost) {
            prizeSelect.setTitle("Keep trying!");
            prizeSelect.setHeaderText("You have not accumulated enough starts to choose this reward yet.");
            prizeSelect.setContentText(String.format("You have %d stars.", generalController.getStars()));

            prizeSelect.showAndWait();
        } else {
            prizeSelect.setTitle("You have selected a prize.");
            prizeSelect.setHeaderText(String.format("Congratulations! You won : %s", generalController.getPrizeHashMap().get(boxString)[1]));
            generalController.setStars(generalController.getStars() - cost);
            prizeSelect.setContentText(String.format("You have %d stars left.", generalController.getStars()));
            prizeSelect.showAndWait();
        }
    }
}
