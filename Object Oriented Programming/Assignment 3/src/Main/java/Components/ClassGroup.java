package Components;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassGroup implements Serializable {
    private String classGroupName;
    private ArrayList<Student> studentArrayList;

    public ClassGroup(String classGroupName) {
        this.studentArrayList = new ArrayList<>();
        this.classGroupName = classGroupName;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public String getClassGroupName() {
        return classGroupName;
    }

    public void addStudent(Student student) {
        this.studentArrayList.add(student);
    }

    @Override
    public String toString() {
        return this.classGroupName;
    }
}
