package GUI;

import Components.Assignment;
import Components.Module;
import Components.Student;
import Controllers.School;
import Controllers.StudentDetailsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class StudentDetails extends Tab {

    private Student student;

    public StudentDetails(School school, Student student) {

        this.student = student;

        this.setText(this.student.getName() + " Details");

        Label name =        new Label("Name : " + this.student.getName().getFirstName() + ' ' + this.student.getName().getMiddleName() + ' ' + this.student.getName().getLastName());
        Label email =       new Label("Email : " + this.student.getEmail());
        Label phoneNumber = new Label("Phone Number : " + this.student.getPhoneNumber());
        Label classGroup =  new Label("Class Group : " + this.student.getClassGroup().getClassGroupName());

        ObservableList<String> options = FXCollections.observableArrayList();

        for (Module module : this.student.getModules()) {
            options.add(module.getModuleName());
        }

        ObservableList<Assignment> assignmentObservableList = FXCollections.observableArrayList();

        ListView<Assignment> gradesListView = new ListView<>(assignmentObservableList);

        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.getSelectionModel().selectFirst();

        Button showButton =             new Button("Show");
        Button closeTabButton =         new Button("Close Tab");
        Button addModuleButton =        new Button("Add Module");
        Button addAssignmentButton =    new Button("Add Assignment");

        GridPane gridPane =             new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(name,                  0, 0);
        gridPane.add(email,                 0, 1);
        gridPane.add(phoneNumber,           0, 2);
        gridPane.add(classGroup,            0, 3);

        gridPane.add(comboBox,              0, 4);
        gridPane.add(showButton,            1, 4);
        gridPane.add(addModuleButton,       1, 5);
        gridPane.add(addAssignmentButton,   1, 6);

        gridPane.add(gradesListView,        0, 5, 1, 3);
        gridPane.add(closeTabButton,        0, 10);

        this.setContent(gridPane);

        StudentDetailsController studentDetailsController = new StudentDetailsController(school, this);

        showButton.setOnAction(event -> studentDetailsController.showModuleGrades(this.student, assignmentObservableList, String.valueOf(comboBox.getSelectionModel().getSelectedItem())));

        addModuleButton.setOnAction(event -> {
            TextInputDialog dialog =    new TextInputDialog();
            dialog.setTitle             ("New Module Window");
            dialog.setHeaderText        ("New Module");
            dialog.setContentText       ("Please enter module name : ");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(s -> {
                studentDetailsController.addModule(s);
                options.add(s);
            });
        });

        addAssignmentButton.setOnAction(event -> {

            if (this.student.getModules().isEmpty()) {

                Alert noModulesAlert =          new Alert(Alert.AlertType.INFORMATION);
                noModulesAlert.setTitle         ("No modules");
                noModulesAlert.setHeaderText    ("No modules");
                noModulesAlert.setContentText   ("No assignments can be created because this student is not taking any modules.");

                noModulesAlert.showAndWait();
                return;
            }

            ChoiceDialog<Module> moduleChoiceDialog =   new ChoiceDialog<>(this.student.getModules().get(0), this.student.getModules());
            moduleChoiceDialog.setTitle                 ("New Assignment Window");
            moduleChoiceDialog.setHeaderText            ("New Assignment");
            moduleChoiceDialog.setContentText           ("Please choose a Module : ");

            TextInputDialog assignmentNameDialog =      new TextInputDialog();
            assignmentNameDialog.setTitle               ("New Assignment Window");
            assignmentNameDialog.setHeaderText          ("New Module");
            assignmentNameDialog.setContentText         ("Please enter assignment name : ");

            TextInputDialog assignmentScoreDialog =     new TextInputDialog();
            assignmentScoreDialog.setTitle              ("New Assignment Window");
            assignmentScoreDialog.setHeaderText         ("New Module");
            assignmentScoreDialog.setContentText        ("Please enter assignment score : ");

            Optional<Module> module = moduleChoiceDialog.showAndWait();
            module.ifPresent(selectedModule -> {
                Optional<String> assignmentName = assignmentNameDialog.showAndWait();
                assignmentName.ifPresent(newAssignmentName -> {
                    Optional<String> assignmentScore = assignmentScoreDialog.showAndWait();
                    assignmentScore.ifPresent(newAssignmentScore -> studentDetailsController.addAssignment(selectedModule, newAssignmentName, newAssignmentScore));
                });
            });
        });

        closeTabButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));
    }

    public Student getStudent() {
        return student;
    }
}
