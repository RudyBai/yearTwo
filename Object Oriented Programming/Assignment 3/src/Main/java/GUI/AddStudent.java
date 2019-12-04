package GUI;

import Components.ClassGroup;
import Controllers.AddStudentController;
import Controllers.School;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddStudent extends Tab {
    private TextField nameField;
    private TextField emailField;
    private TextField phoneNumberField;

    public AddStudent(School school) {

        Label nameLabel = new Label("Name");
        Label emailLabel = new Label("Email");
        Label phoneNumberLabel = new Label("Phone Number");
        Label classGroupLabel = new Label("Class Group");

        nameField = new TextField();
        emailField = new TextField();
        phoneNumberField = new TextField();

        Button addButton = new Button("Add");
        Button clearButton = new Button("Clear");
        Button closeButton = new Button("Close");

        GridPane gridPane = new GridPane();

        ComboBox<ClassGroup> classGroupComboBox = new ComboBox<>(school.getClassGroupObservableList());
        classGroupComboBox.getSelectionModel().selectFirst();

        gridPane.add(nameLabel, 0, 0, 3, 1);
        gridPane.add(nameField, 0, 1, 3, 1);
        gridPane.add(emailLabel, 0, 2, 3, 1);
        gridPane.add(emailField, 0, 3, 3, 1);
        gridPane.add(phoneNumberLabel, 0, 4, 3, 1);
        gridPane.add(phoneNumberField, 0, 5, 3, 1);
        gridPane.add(classGroupLabel, 0, 6, 3, 1);
        gridPane.add(classGroupComboBox, 0, 7, 3, 1);
        gridPane.add(addButton, 0, 8);
        gridPane.add(clearButton, 1, 8);
        gridPane.add(closeButton, 2, 8);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        classGroupComboBox.setPrefWidth(200);

        this.setText("Add Student");

        this.setContent(gridPane);

        AddStudentController addStudentController = new AddStudentController(school);

        addButton.setOnAction(event -> {
            addStudentController.addStudent(nameField.getText(), emailField.getText(), phoneNumberField.getText(), classGroupComboBox.getSelectionModel().getSelectedItem().getClassGroupName());
            school.refreshClassGroupObservableList();
            clear();
        });

        clearButton.setOnAction(event -> clear());

        closeButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));
    }

    private void clear() {
        this.nameField.setText("");
        this.emailField.setText("");
        this.phoneNumberField.setText("");
    }
}
