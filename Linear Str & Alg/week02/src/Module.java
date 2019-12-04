/**
* Our second pure Object Oriented Programming Java class, in the sense it is used to model a concept (a type of objects) of the problem we want to solve<br>. 
* The module class produces and give functionality to n >= 0 module objects<br>
*/
import java.util.ArrayList;
import java.util.List;

public class Module {

	//---------------------------------------
	//	Attributes
	//---------------------------------------
	private String name;
	private int code;
	private int students;
	private int maxStudents;
	private List<Student> registered = new ArrayList<Student>();
	//---------------------------------------
	//	Constructor
	//---------------------------------------
	public Module(String a, int b) {
		this.name = a;
		this.code = b;
		this.students = 0;
		this.maxStudents = 20;
	}
	//---------------------------------------
	//	Get Methods
	//---------------------------------------	
	public String getName() {
		return name;
	}
	public int getCode() {
		return code;
	}
	//-------------------------------------
	//	Set Method
	//---------------------------------------		
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(int code) {
		this.code = code;
	}
	//---------------------------------------
	//	Extra Functionality
	//---------------------------------------		
	public void registerStudent(Student a) {
		if (students < maxStudents) {
		registered.add(a);
		System.out.println("Student registed");
		this.students++;
		}
		else {
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
