package Controllers;

import Components.ClassGroup;
import Components.Name;
import Components.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class AddStudentController {

    private School school;

    public AddStudentController(School school) {
        this.school = school;
    }

    public void addStudent(String nameString, String email, String phoneNumber, String classGroupString) {
        ArrayList<String> nameArrayList = new ArrayList<>(Arrays.asList(nameString.split(" ")));

        String fName = nameArrayList.get(0);
        StringBuilder mName = new StringBuilder();

        for (int i = 1; i < nameArrayList.size() - 1; i++) {
            mName.append(nameArrayList.get(i));
        }

        String lName = nameArrayList.get(nameArrayList.size() - 1);

        for (ClassGroup classGroup : school.getClassGroupObservableList()) {
            if (classGroupString.equals(classGroup.getClassGroupName())) {
                Student student = new Student(new Name(fName, mName.toString(), lName), email, phoneNumber, classGroup);
                school.getMySQLController().addStudent(student);
                return;
            }
        }

        System.out.println("Class Group not Found");
    }
}
