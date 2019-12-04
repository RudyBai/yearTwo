import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Tab used to add cars to list
 */
public class CarTab extends Tab {

    // Attributes
    private TextField makeField;
    private TextField modelField;
    private TextField registrationField;
    private TextField millageField;
    private TextField yearOfManufactureField;

    private CarTabController carTabController;

    /**
     * Constructor for the tab
     * =================================
     * ==== SET CONTROLLER MANUALLY ====
     * =================================
     */
    // Constructor
    CarTab() {

        // Set Tab Title
        this.setText("Add New Car");

        // Instantiate TextFields
        this.makeField = new TextField();
        this.modelField = new TextField();
        this.registrationField = new TextField();
        this.millageField = new TextField();
        this.yearOfManufactureField = new TextField();

        // Instantiate Labels
        Label makeLabel = new Label("Make");
        Label modelLabel = new Label("Model");
        Label registrationLabel = new Label("Registration");
        Label millageLabel = new Label("Millage");
        Label yearOfManufactureLabel = new Label("Year of Manufacture");

        // Instantiate Buttons
        Button addCar = new Button("Add");
        Button clear = new Button("Clear");
        Button quit = new Button("Quit");

        // Create Layout
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);

        // Set column width
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(1.0 / 3.0 * 80);
        gridPane.getColumnConstraints().addAll(col1, col1, col1);

        // Button Width
        addCar.setPrefWidth(50);
        clear.setPrefWidth(50);
        quit.setPrefWidth(50);

        // Layout alignment, width and gaps
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(2);
        gridPane.setPrefWidth(150);

        // Add elements to layout
        gridPane.add(makeLabel, 0, 0, 3, 1);
        gridPane.add(makeField, 0, 1, 3, 1);
        gridPane.add(modelLabel, 0, 2, 3, 1);
        gridPane.add(modelField, 0, 3, 3, 1);
        gridPane.add(registrationLabel, 0, 4, 3, 1);
        gridPane.add(registrationField, 0, 5, 3, 1);
        gridPane.add(millageLabel, 0, 6, 3, 1);
        gridPane.add(millageField, 0, 7, 3, 1);
        gridPane.add(yearOfManufactureLabel, 0, 8, 3, 1);
        gridPane.add(yearOfManufactureField, 0, 9, 3, 1);
        gridPane.add(addCar, 0, 10);
        gridPane.add(clear, 1, 10);
        gridPane.add(quit, 2, 10);

        // Add Layout to Tab
        this.setContent(gridPane);

        // ======================
        // === Event Handlers ===
        // ======================

        // Add Car
        addCar.setOnAction(e -> this.carTabController.addCar());

        // Clear
        clear.setOnAction(e -> this.carTabController.clear());

        // Quit
        quit.setOnAction(e -> ((Stage) this.getTabPane().getScene().getWindow()).close());


    }

    /**
     * @return makeField getter
     */
    TextField getMakeField() {
        return makeField;
    }

    /**
     * @return modelField getter
     */
    TextField getModelField() {
        return modelField;
    }

    /**
     * @return registrationField getter
     */
    TextField getRegistrationField() {
        return registrationField;
    }

    /**
     * @return millageField getter
     */
    TextField getMillageField() {
        return millageField;
    }

    /**
     * @return yearOfManufactureField getter
     */
    TextField getYearOfManufactureField() {
        return yearOfManufactureField;
    }

    /**
     * @param carTabController carTabController setter
     */
    void setCarTabController(CarTabController carTabController) {
        this.carTabController = carTabController;
    }

}
