package Controllers;

import Components.ClassGroup;

public class AddClassGroupController {

    private School school;

    public AddClassGroupController(School school) {
        this.school = school;
    }

    public void addClassGroup(String classGroupName) {

        if (classGroupName.isEmpty()) {
            System.out.println("Name empty : no class group made");
            return;
        }

        ClassGroup classGroup = new ClassGroup(classGroupName);
        school.getMySQLController().addClassGroup(classGroup);
        school.getClassGroupObservableList().add(classGroup);
    }
}
