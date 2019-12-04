package Controllers;

import Components.Name;
import Components.Teacher;
import GUI.TeacherList;

import java.util.ArrayList;
import java.util.Arrays;

public class TeacherListController {
    private School school;
    private TeacherList teacherList;

    public TeacherListController(School school, TeacherList teacherList) {
        this.school = school;
        this.teacherList = teacherList;
    }

    public void addTeacher(String name, String email, String phoneNumber) {
        ArrayList<String> nameArrayList = new ArrayList<>(Arrays.asList(name.split(" ")));

        String fName = nameArrayList.get(0);
        StringBuilder mName = new StringBuilder();

        for (int i = 1; i < nameArrayList.size() - 1; i++) {
            mName.append(nameArrayList.get(i));
        }

        String lName = nameArrayList.get(nameArrayList.size() - 1);

        Teacher teacher = new Teacher(new Name(fName, String.valueOf(mName), lName), email, phoneNumber);

        school.getTeacherObservableList().add(teacher);

        school.getMySQLController().addTeacher(teacher);
        school.refreshTeacherObservableList();
    }

    public void refresh() {
        school.refreshTeacherObservableList();
        teacherList.getTeacherListView().setItems(school.getTeacherObservableList());
    }

    public void removeTeacher(Teacher teacher) {
        school.getMySQLController().removeTeacher(teacher);
    }

    public void editDegree(String degree, Teacher teacher) {
        teacher.setDegree(degree);
        System.out.println("Teacher degree set to : " + teacher.getDegree());
        school.getMySQLController().removeTeacher(teacher);
        school.getMySQLController().addTeacher(teacher);
        school.refreshTeacherObservableList();
        teacherList.getTeacherListView().setItems(school.getTeacherObservableList());
    }
}
