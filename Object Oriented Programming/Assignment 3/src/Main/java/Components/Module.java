package Components;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {
    private String moduleName;
    private ArrayList<Assignment> assignments;

    public Module(String moduleName, ArrayList<Assignment> assignments) {
        this.moduleName = moduleName;
        this.assignments = assignments;
    }

    public String getModuleName() {
        return moduleName;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return moduleName;
    }
}
