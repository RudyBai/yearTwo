import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * Tab which lists cars and all their attributes
 */
public class CarListTab extends Tab {

    // Attributes
    private ObservableList<Car> carObservableList;
    private ListView<Car> carListView;

    private CarListTabController carListTabController;

    /**
     * Constructor of class
     * <p>
     * =================================
     * ==== SET CONTROLLER MANUALLY ====
     * =================================
     */
    // Constructor
    CarListTab() {

        // Set Tab Title
        this.setText("List of Cars");

        // Create List View
        ArrayList<Car> carArrayList = new ArrayList<>();
        this.carObservableList = FXCollections.observableList(carArrayList);
        carListView = new ListView<>(carObservableList);

        // Create Buttons
        Button removeButton = new Button("Remove");
        Button save = new Button("Save");
        Button load = new Button("Load");
        Button alphaOrder = new Button("Alphabetical");
        Button millageOrder = new Button("Millage");
        Button yearOrder = new Button("Year of Manufacture");

        // Button width attribute
        int buttonWidth = 125;

        // Set width of all buttons
        removeButton.setMinWidth(buttonWidth);
        save.setMinWidth(buttonWidth);
        load.setMinWidth(buttonWidth);
        alphaOrder.setMinWidth(buttonWidth);
        millageOrder.setMinWidth(buttonWidth);
        yearOrder.setMinWidth(buttonWidth);

        // Create Layout
        GridPane gridPane = new GridPane();

        // Layout alignment and gaps
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(2);

        // Add elements to layout
        gridPane.add(carListView, 0, 0, 3, 10);
        gridPane.add(removeButton, 3, 0);
        gridPane.add(load, 3, 1);
        gridPane.add(save, 3, 2);
        gridPane.add(alphaOrder, 3, 3);
        gridPane.add(millageOrder, 3, 4);
        gridPane.add(yearOrder, 3, 5);

        // Add layout to Tab
        this.setContent(gridPane);

        // ======================
        // === Event Handlers ===
        // ======================

        // Remove
        removeButton.setOnAction(actionEvent -> carListTabController.remove(carListView.getSelectionModel().getSelectedItem()));

        // Load
        load.setOnAction(actionEvent -> this.carListTabController.load());

        // Save
        save.setOnAction(actionEvent -> this.carListTabController.save(new ArrayList<>(this.getCarObservableList())));

        // Alphabetical Order
        alphaOrder.setOnAction(actionEvent -> this.carListTabController.alphaOrder());

        // Millage Order
        millageOrder.setOnAction(actionEvent -> this.carListTabController.millageOrder());

        // Year Order
        yearOrder.setOnAction(actionEvent -> this.carListTabController.yearOrder());

    }

    /**
     * @param carListTabController Controller to be assigned to this class
     */
    void setCarListTabController(CarListTabController carListTabController) {
        this.carListTabController = carListTabController;
    }

    /**
     * @param carObservableList ObservableList to be set
     */
    void setCarObservableList(ObservableList<Car> carObservableList) {
        this.carObservableList = carObservableList;
    }

    /**
     * @return CarListTabController getter
     */
    CarListTabController getCarListTabController() {
        return carListTabController;
    }

    /**
     * @return CarObservableList getter
     */
    ObservableList<Car> getCarObservableList() {
        return carObservableList;
    }


}
