package GUI;

import Components.Teacher;
import Controllers.School;
import Controllers.TeacherListController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class TeacherList extends Tab {

    private ListView<Teacher> teacherListView;

    public TeacherList(School school) {

        teacherListView =           new ListView<>(school.getTeacherObservableList());
        Button addTeacherButton =   new Button("Add Teacher");
        Button editButton =         new Button("Edit");
        Button removeButton =       new Button("Remove");
        Button refreshButton =      new Button("Refresh");
        Button closeButton =        new Button("Close");
        GridPane gridPane =         new GridPane();

        this.setText("Teacher List");

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(teacherListView,   0, 0, 1, 6);
        gridPane.add(addTeacherButton,  1, 0);
        gridPane.add(editButton,        1, 1);
        gridPane.add(removeButton,      1, 2);
        gridPane.add(refreshButton,     1, 3);
        gridPane.add(closeButton,       1, 4);

        TeacherListController teacherListController = new TeacherListController(school, this);

        this.setContent(gridPane);

        addTeacherButton.setOnAction(event -> {
            TextInputDialog teacherNameDialog =             new TextInputDialog();
            teacherNameDialog.setTitle                      ("New Teacher Window");
            teacherNameDialog.setHeaderText                 ("New Teacher");
            teacherNameDialog.setContentText                ("Please enter teacher name : ");

            TextInputDialog teacherEmailDialog =            new TextInputDialog();
            teacherEmailDialog.setTitle                     ("New Teacher Window");
            teacherEmailDialog.setHeaderText                ("New Teacher");
            teacherEmailDialog.setContentText               ("Please enter teacher email : ");

            TextInputDialog teacherPhoneNumberDialog =      new TextInputDialog();
            teacherPhoneNumberDialog.setTitle               ("New Teacher Window");
            teacherPhoneNumberDialog.setHeaderText          ("New Teacher");
            teacherPhoneNumberDialog.setContentText         ("Please enter teacher phone number : ");

            Optional<String> newTeacherName = teacherNameDialog.showAndWait();
            newTeacherName.ifPresent(name -> {
                Optional<String> newTeacherEmail = teacherEmailDialog.showAndWait();
                newTeacherEmail.ifPresent(email -> {
                    Optional<String> newTeacherPhoneNumber = teacherPhoneNumberDialog.showAndWait();
                    newTeacherPhoneNumber.ifPresent(phoneNumber -> teacherListController.addTeacher(name, email, phoneNumber));
                });
            });
        });

        refreshButton.setOnAction(event -> teacherListController.refresh());

        removeButton.setOnAction(event -> teacherListController.removeTeacher(teacherListView.getSelectionModel().getSelectedItem()));

        editButton.setOnAction(event -> {
            TextInputDialog teacherNewDegree =              new TextInputDialog();
            teacherNewDegree.setTitle                       ("Edit Degree Window");
            teacherNewDegree.setHeaderText                  ("New Degree");
            teacherNewDegree.setContentText                 ("Please enter teacher degree : ");

            Optional<String> degree = teacherNewDegree.showAndWait();
            degree.ifPresent(newDegree -> teacherListController.editDegree(newDegree, teacherListView.getSelectionModel().getSelectedItem()));
        });

        closeButton.setOnAction(event -> this.getTabPane().getTabs().remove(this));
    }

    public ListView<Teacher> getTeacherListView() {
        return teacherListView;
    }
}
