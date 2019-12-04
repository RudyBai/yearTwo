package GUI;

import Components.Student;
import Controllers.School;
import Controllers.StudentListController;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class StudentList extends Tab {

    private ListView<Student> studentListView;
    private ObservableList<Student> studentObservableList;

    public StudentList(School school, ObservableList<Student> studentObservableList) {

        this.studentObservableList = studentObservableList;
        studentListView =           new ListView<>(studentObservableList);
        Button addButton =          new Button("Add");
        Button removeButton =       new Button("Remove");
        Button detailsButton =      new Button("Details");
        Button closeTabButton =     new Button("Close Tab");

        GridPane gridPane =         new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        this.setText("Student List");

        gridPane.add(studentListView,   0, 0, 3, 5);
        gridPane.add(addButton,         3, 0);
        gridPane.add(detailsButton,     3, 1);
        gridPane.add(removeButton,      3, 2);
        gridPane.add(closeTabButton,    0, 5);

        this.setContent(gridPane);

        StudentListController studentListController = new StudentListController(this, school);

        addButton.setOnAction(event -> studentListController.openAddStudentTab());

        detailsButton.setOnAction(event -> studentListController.openDetailsTab(studentListView.getSelectionModel().getSelectedItem()));

        removeButton.setOnAction(event -> studentListController.removeStudent(studentListView.getSelectionModel().getSelectedItem()));

        closeTabButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));

    }

    public ObservableList<Student> getStudentObservableList() {
        return studentObservableList;
    }
}
