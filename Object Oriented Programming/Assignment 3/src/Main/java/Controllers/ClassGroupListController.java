package Controllers;

import Components.ClassGroup;
import Components.Student;
import GUI.AddClassGroup;
import GUI.ClassGroupList;
import GUI.StudentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

import java.util.ArrayList;

public class ClassGroupListController {

    private ClassGroupList classGroupList;
    private School school;

    public ClassGroupListController(ClassGroupList classGroupList, School school) {
        this.classGroupList = classGroupList;
        this.school = school;
    }

    public void openAddClassGroupTab() {

        for (Tab tab : classGroupList.getTabPane().getTabs()) {
            if (tab.getText().equals("Add Class Group")) {
                classGroupList.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        AddClassGroup addClassGroup = new AddClassGroup(school);
        classGroupList.getTabPane().getTabs().add(addClassGroup);
        classGroupList.getTabPane().getSelectionModel().select(addClassGroup);
    }

    public void showStudentsTab(ClassGroup classGroup) {

        if (classGroup == null) {

            System.out.println("No ClassGroup selected.");

            return;
        }

        StudentList studentList = new StudentList(school, FXCollections.observableArrayList(classGroup.getStudentArrayList()));
        studentList.setText(classGroup.getClassGroupName() + " Student List");
        classGroupList.getTabPane().getTabs().add(studentList);
        classGroupList.getTabPane().getSelectionModel().select(studentList);

    }

    public void showAllStudentsTab() {

        ArrayList<Student> studentArrayList = new ArrayList<>();

        for (ClassGroup classGroup : school.getClassGroupObservableList()) {
            studentArrayList.addAll(classGroup.getStudentArrayList());
        }

        ObservableList<Student> studentObservableList = FXCollections.observableList(studentArrayList);

        StudentList studentList = new StudentList(school, FXCollections.observableList(studentObservableList));
        classGroupList.getTabPane().getTabs().add(studentList);
        classGroupList.getTabPane().getSelectionModel().select(studentList);

    }

    public void refresh() {
        school.refreshClassGroupObservableList();
        classGroupList.getClassGroupListView().setItems(school.getClassGroupObservableList());
    }

    public void remove(ClassGroup classGroup) {

        if (classGroup == null) {
            System.out.println("No Class Group Selected");
            return;
        }

        school.getMySQLController().removeClassGroup(classGroup);
        school.getClassGroupObservableList().remove(classGroup);
    }
}
