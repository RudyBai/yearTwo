package GUI;

import Controllers.AddClassGroupController;
import Controllers.School;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddClassGroup extends Tab {

    public AddClassGroup(School school) {
        Label classGroupNameLabel = new Label("Class Group Name");
        TextField classGroupNameField = new TextField();
        Button addButton = new Button("Add");
        Button closeButton = new Button("Close");

        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        this.setText("Add Class Group");
        this.setClosable(false);

        gridPane.add(classGroupNameLabel,   0, 0, 2, 1);
        gridPane.add(classGroupNameField,   0, 1, 2, 1);
        gridPane.add(addButton,             0, 2);
        gridPane.add(closeButton,           1, 2);

        this.setContent(gridPane);

        AddClassGroupController addClassGroupController = new AddClassGroupController(school);

        addButton.setOnAction(event -> {
            addClassGroupController.addClassGroup(classGroupNameField.getText());
            classGroupNameField.setText("");
        });

        closeButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));
    }
}