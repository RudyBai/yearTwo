package Controllers;

import Components.Student;
import GUI.AddStudent;
import GUI.StudentDetails;
import GUI.StudentList;
import javafx.scene.control.Tab;

public class StudentListController {

    private StudentList studentList;
    private School school;

    public StudentListController(StudentList studentList, School school) {
        this.studentList = studentList;
        this.school = school;
    }

    public void openAddStudentTab() {

        for (Tab tab : studentList.getTabPane().getTabs()) {
            if (tab.getText().equals("Add Student")) {
                studentList.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        AddStudent addStudent = new AddStudent(school);
        studentList.getTabPane().getTabs().add(addStudent);
        studentList.getTabPane().getSelectionModel().select(addStudent);
    }

    public void openDetailsTab(Student student) {
        if (student == null) {
            System.out.println("No student selected");
            return;
        }
        for (Tab tab : studentList.getTabPane().getTabs()) {
            if (tab.getText().equals(student.getName() + " Details")) {
                studentList.getTabPane().getSelectionModel().select(tab);
                return;
            }
        }

        StudentDetails studentDetails = new StudentDetails(school, student);
        studentList.getTabPane().getTabs().add(studentDetails);
        studentList.getTabPane().getSelectionModel().select(studentDetails);
    }

    public void removeStudent(Student student) {
        school.getMySQLController().removeStudent(student);
        studentList.getStudentObservableList().remove(student);
        school.refreshClassGroupObservableList();
    }
}