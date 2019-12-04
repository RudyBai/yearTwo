package Controllers;

import GUI.*;
import javafx.scene.control.Tab;

public class MainMenuController {

    private School school;
    private MainMenu mainMenu;

    public MainMenuController(School school, MainMenu mainMenu) {
        this.school = school;
        this.mainMenu = mainMenu;
    }

    public void openAddClassGroupTab() {
        for (Tab tab : mainMenu.getTabPane().getTabs()) {
            if (tab.getText().equals("Add Class Group")) {
                mainMenu.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        AddClassGroup addClassGroup = new AddClassGroup(school);
        mainMenu.getTabPane().getTabs().add(addClassGroup);
        mainMenu.getTabPane().getSelectionModel().select(addClassGroup);
    }

    public void openAddStudentTab() {
        for (Tab tab : mainMenu.getTabPane().getTabs()) {
            if (tab.getText().equals("Add Student")) {
                mainMenu.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        AddStudent addStudent = new AddStudent(school);
        mainMenu.getTabPane().getTabs().add(addStudent);
        mainMenu.getTabPane().getSelectionModel().select(addStudent);
    }

    public void openClassGroupListTab() {
        for (Tab tab : mainMenu.getTabPane().getTabs()) {
            if (tab.getText().equals("Class Group List")) {
                mainMenu.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        ClassGroupList classGroupList = new ClassGroupList(school);
        mainMenu.getTabPane().getTabs().add(classGroupList);
        mainMenu.getTabPane().getSelectionModel().select(classGroupList);
    }

    public void openTeacherList() {
        for (Tab tab : mainMenu.getTabPane().getTabs()) {
            if (tab.getText().equals("Teacher List")) {
                mainMenu.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        TeacherList teacherList = new TeacherList(school);
        mainMenu.getTabPane().getTabs().add(teacherList);
        mainMenu.getTabPane().getSelectionModel().select(teacherList);
    }

}
