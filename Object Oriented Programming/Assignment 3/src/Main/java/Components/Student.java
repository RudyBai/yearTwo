package Components;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Module> modules;
    private ClassGroup classGroup;

    public Student(Name name, String email, String phoneNumber, ClassGroup classGroup) {
        super(name, email, phoneNumber);
        this.modules = new ArrayList<>();
        this.classGroup = classGroup;
    }

    public Student(Name name, String email, String phoneNumber, ArrayList<Module> moduleArrayList, ClassGroup classGroup) {
        super(name, email, phoneNumber);
        this.modules = moduleArrayList;
        this.classGroup = classGroup;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public ClassGroup getClassGroup() {
        return classGroup;
    }

    @Override
    public String toString() {
        return super.getName().toString() + "\n" + "Class Group : " + this.classGroup.toString();
    }
}
