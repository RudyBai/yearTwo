import java.util.ArrayList;
import java.util.List;

public class Module {
    /**
     * Our second pure Object Oriented Programming Java class, in the sense it is used to model a concept (a type of objects) of the problem we want to solve<br>.
     * The module class produces and give functionality to n >= 0 module objects<br>
     */
    //---------------------------------------
    //	Attributes
    //---------------------------------------
    private int students;
    private int maxStudents;
    private List<Student> registered = new ArrayList<>();

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    public Module() {
        this.students = 0;
        this.maxStudents = 20;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------
    public void registerStudent(Student a) {
        if (students < maxStudents) {
            registered.add(a);
            System.out.println("Student registered");
            this.students++;
        } else {
            System.out.println("Maximum students registered");
        }
    }

    public Student getStudentInfo(int a) {
        Student res = null;
        if (a < this.students) {
            res = this.registered.get(a);
        }
        return res;
    }
}