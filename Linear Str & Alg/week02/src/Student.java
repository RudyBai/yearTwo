/**
* Our first pure Object Oriented Programming Java class, in the sense it is used to model a concept (a type of objects) of the problem we want to solve<br>. 
* The student class produces and give functionality to n >= 0 student objects<br>
*/
public class Student {

	//---------------------------------------
	//	Attributes
	//---------------------------------------
	String name = "Bart";
	int age = 20;
	boolean firstYear = false;
	
	//---------------------------------------
	//	Constructor
	//---------------------------------------
	public Student(String a, int b, boolean c) {
		this.name = a;
		this.age = b;
		this.firstYear = c;
	}	
	//---------------------------------------
	//	Get Methods
	//---------------------------------------	
	public boolean getFirstYear() {
		return firstYear;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	//---------------------------------------
	//	Set Method
	//---------------------------------------		
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setFirstYear(boolean firstYear) {
		this.firstYear = firstYear;
	}
	//---------------------------------------
	//	Extra Functionality
	//---------------------------------------		
	public void birthday() {
		if (age == 1) {
		this.age++;
		System.out.println("Happy birthday " + name + "! We hope you had a nice first year of college!");
		}
		else {
			this.age++;
			System.out.println("Happy birthday" + name + "!");
		}
	}
	
}