import Components.ClassGroup;
import Components.Module;
import Components.Name;
import Components.Student;

import java.util.ArrayList;

public class TestOne {
    public static void main(String[] args) {
        ClassGroup classGroupOne = new ClassGroup("IT2");
        Student studentOne = new Student(new Name("Colin", "", "Foot"), "colin.foot@mycit.ie", "0875045432", classGroupOne);
        Student studentTwo = new Student(new Name("Jerry", "O'", "Brien"), "jerry.obrien@mycit.ie", "0876136898", classGroupOne);

        classGroupOne.addStudent(studentOne);
        classGroupOne.addStudent(studentTwo);

        studentOne.addModule(new Module("OOP", new ArrayList<>()));
    }
}
