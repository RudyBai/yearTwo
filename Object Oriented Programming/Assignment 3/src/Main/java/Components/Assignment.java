package Components;

import java.io.Serializable;

public class Assignment implements Serializable {

    private String assignmentName;
    private Double grade;

    public Assignment(String assignment, Double grade) {
        this.assignmentName = assignment;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return assignmentName + '\n' + grade + "%";
    }
}
