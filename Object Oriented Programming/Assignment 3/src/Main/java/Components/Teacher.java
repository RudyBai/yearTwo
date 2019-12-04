package Components;

public class Teacher extends Person {

    private String degree;

    public Teacher(Name name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.degree = null;
    }

    public Teacher(Name name, String email, String phoneNumber, String degree) {
        super(name, email, phoneNumber);
        this.degree = degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return super.getName().toString() + '\n' + this.degree;
    }
}
