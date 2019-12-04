package GUI;

import Controllers.MainMenuController;
import Controllers.School;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainMenu extends Tab {

    public MainMenu(School school) {

        Image image =                       new Image("mainMenuImage.png", true);
        Button addStudentButton =           new Button("Add Student");
        Button addClassGroupButton =        new Button("Add Class Group");
        Button classGroupListButton =       new Button("Class Group List");
        Button teacherListButton =          new Button("Teacher List");

        addClassGroupButton                 .setPrefWidth(337.5 / 2);
        addStudentButton                    .setPrefWidth(337.5 / 2);
        classGroupListButton                .setPrefWidth(337.5 / 2);
        teacherListButton                   .setPrefWidth(337.5 / 2);

        ImageView imageView =               new ImageView(image);
        imageView                           .setFitHeight(232.5);
        imageView                           .setFitWidth(337.5);

        GridPane gridPane =                 new GridPane();

        gridPane                            .setHgap(10);
        gridPane                            .setVgap(10);
        gridPane                            .setAlignment(Pos.CENTER);

        gridPane                            .setPrefWidth(337.5);

        this.setText("Main Menu");

        gridPane.add(imageView,             0, 0, 2, 3);
        gridPane.add(addStudentButton,      0, 3);
        gridPane.add(addClassGroupButton,   1, 3);
        gridPane.add(classGroupListButton,  0, 4);
        gridPane.add(teacherListButton,     1, 4);

        this.setContent(gridPane);

        MainMenuController mainMenuController = new MainMenuController(school, this);

        addStudentButton.setOnAction(event -> mainMenuController.openAddStudentTab());

        addClassGroupButton.setOnAction(event -> mainMenuController.openAddClassGroupTab());

        classGroupListButton.setOnAction(event -> mainMenuController.openClassGroupListTab());

        teacherListButton.setOnAction(event -> mainMenuController.openTeacherList());

    }
}
