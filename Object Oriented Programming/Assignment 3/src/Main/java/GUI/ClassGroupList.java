package GUI;

import Components.ClassGroup;
import Controllers.ClassGroupListController;
import Controllers.School;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class ClassGroupList extends Tab {

    private ListView<ClassGroup> classGroupListView;

    public ClassGroupList(School school) {
        classGroupListView =                new ListView<>(school.getClassGroupObservableList());
        Button addButton =                  new Button("Add");
        Button studentsButton =             new Button("Show Students");
        Button allStudentsButton =          new Button("Show All Students");
        Button refreshButton =              new Button("Refresh");
        Button removeButton =               new Button("Remove");
        Button closeButton =                new Button("Close");
        GridPane gridPane =                 new GridPane();

        this.setText("Class Group List");

        gridPane                            .setHgap(10);
        gridPane                            .setVgap(10);
        gridPane                            .setAlignment(Pos.CENTER);

        gridPane.add(classGroupListView,    0, 0, 3, 7);
        gridPane.add(addButton,             3, 0);
        gridPane.add(studentsButton,        3, 1);
        gridPane.add(allStudentsButton,     3, 2);
        gridPane.add(refreshButton,         3, 3);
        gridPane.add(removeButton,          3, 4);
        gridPane.add(closeButton,           3, 5);

        this.setContent(gridPane);

        ClassGroupListController classGroupListController = new ClassGroupListController(this, school);

        addButton.setOnAction(event -> classGroupListController.openAddClassGroupTab());

        studentsButton.setOnAction(event -> classGroupListController.showStudentsTab(classGroupListView.getSelectionModel().getSelectedItem()));

        allStudentsButton.setOnAction(event -> classGroupListController.showAllStudentsTab());

        refreshButton.setOnAction(event -> classGroupListController.refresh());

        removeButton.setOnAction(event -> classGroupListController.remove(classGroupListView.getSelectionModel().getSelectedItem()));

        closeButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));
    }

    public ListView<ClassGroup> getClassGroupListView() {
        return classGroupListView;
    }
}