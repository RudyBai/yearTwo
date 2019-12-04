package Controllers;

import Components.Assignment;
import Components.Module;
import Components.Student;
import GUI.StudentDetails;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class StudentDetailsController {

    private School school;
    private StudentDetails studentDetails;

    public StudentDetailsController(School school, StudentDetails studentDetails) {
        this.school = school;
        this.studentDetails = studentDetails;
    }

    public void showModuleGrades(Student student, ObservableList<Assignment> assignmentObservableList, String parameterModule) {
        Module module = null;


        for (Module i : student.getModules()) {
            if (parameterModule.equals(i.getModuleName())) {
                module = i;
            }
        }

        if (module == null) {

            System.out.println("No module selected");

            return;
        }
        assignmentObservableList.clear();
        assignmentObservableList.addAll(module.getAssignments());
    }

    public void addModule(String moduleName) {
        Module module = new Module(moduleName, new ArrayList<>());
        studentDetails.getStudent().addModule(module);

        school.getMySQLController().removeStudent(studentDetails.getStudent());
        school.getMySQLController().addStudent(studentDetails.getStudent());

    }

    public void addAssignment(Module module, String assignmentName, String score) {
        try {
            double scorePercentage = Double.valueOf(score);
            module.getAssignments().add(new Assignment(assignmentName, scorePercentage));
        } catch (NumberFormatException nfe) {
            Alert nfeAlert = new Alert(Alert.AlertType.INFORMATION);
            nfeAlert.setTitle("Number Format Exception");
            nfeAlert.setHeaderText("Number Format Exception");
            nfeAlert.setContentText("Score must be a decimal number.");
        }

        school.getMySQLController().removeStudent(studentDetails.getStudent());
        school.getMySQLController().addStudent(studentDetails.getStudent());
    }
}