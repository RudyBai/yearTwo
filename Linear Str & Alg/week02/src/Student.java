/**
 * Our first pure Object Oriented Programming Java class, in the sense it is used to model a concept (a type of objects) of the problem we want to solve<br>.
 * The student class produces and give functionality to n >= 0 student objects<br>
 */
public class Student {

    //---------------------------------------
    //	Attributes
    //---------------------------------------
    private String name;
    private int age;
    private boolean firstYear;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    public Student(String name, int age, boolean firstYear) {
        this.name = name;
        this.age = age;
        this.firstYear = firstYear;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------
    public boolean getFirstYear() {
        return firstYear;
    }

    public void setFirstYear(boolean firstYear) {
        this.firstYear = firstYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------
    public void birthday() {
        if (firstYear) {
            this.age++;
            System.out.println("Happy birthday " + name + "! We hope you had a nice first year of college!");
        } else {
            this.age++;
            System.out.println("Happy birthday" + name + "!");
        }
    }

}
