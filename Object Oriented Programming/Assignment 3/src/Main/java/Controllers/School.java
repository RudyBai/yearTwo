package Controllers;

import Components.ClassGroup;
import Components.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class School {

    private MySQLController mySQLController;
    private Stage stage;
    private ObservableList<ClassGroup> classGroupObservableList;
    private ObservableList<Teacher> teacherObservableList;


    public School(Stage stage) {
        this.stage = stage;
        this.mySQLController = new MySQLController();
        refreshClassGroupObservableList();
        refreshTeacherObservableList();
    }

    public void close() {
        stage.close();
        mySQLController.close();
    }

    void refreshTeacherObservableList() {
        this.teacherObservableList = FXCollections.observableList(mySQLController.loadTeachers());
        System.out.println("The following teachers have been deserialized : ");
        for (Teacher teacher : this.teacherObservableList) {
            System.out.println(teacher.getName());
        }
    }

    public void refreshClassGroupObservableList() {
        this.classGroupObservableList = FXCollections.observableList(mySQLController.loadClassGroups());
        System.out.println("The following Class Groups have been deserialized : ");
        for (ClassGroup classGroup : this.classGroupObservableList) {
            System.out.println(classGroup.getClassGroupName());
        }
    }


    MySQLController getMySQLController() {
        return mySQLController;
    }

    public ObservableList<ClassGroup> getClassGroupObservableList() {
        return classGroupObservableList;
    }

    public ObservableList<Teacher> getTeacherObservableList() {
        return teacherObservableList;
    }
}
