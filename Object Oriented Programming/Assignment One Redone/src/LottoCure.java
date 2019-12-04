import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

class LottoCure extends Tab {
    private TextField textFieldOne;
    private TextField textFieldTwo;
    private TextField textFieldThree;
    private TextField textFieldFour;
    private TextField textFieldFive;
    private TextField textFieldSix;
    private Label label;
    private Button buttonSubmit;
    private Button buttonReset;
    private ArrayList<Integer> answer;

    private GeneralController generalController;

    LottoCure(GeneralController generalController) {

        // General Controller
        this.generalController = generalController;
        // Set Title
        this.setText("Lotto Cure");

        // Instantiate Elements
        this.textFieldOne = new TextField();
        this.textFieldTwo = new TextField();
        this.textFieldThree = new TextField();
        this.textFieldFour = new TextField();
        this.textFieldFive = new TextField();
        this.textFieldSix = new TextField();
        this.label = new Label("Guess six numbers 1 - 50");
        this.buttonSubmit = new Button("Submit");
        this.buttonReset = new Button("Reset");
        Button buttonQuit = new Button("Quit");

        // Instantiate GridPane
        GridPane gridPane = new GridPane();

        // GridPane Layout
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setHgap(10);

        // Button Layout
        buttonSubmit.setPrefWidth(320);
        buttonQuit.setPrefWidth(320);
        buttonReset.setPrefWidth(320);

        // GridPane Children
        gridPane.add(label, 0, 0, 6, 1);
        gridPane.add(textFieldOne, 0, 1, 1, 1);
        gridPane.add(textFieldTwo, 1, 1, 1, 1);
        gridPane.add(textFieldThree, 2, 1, 1, 1);
        gridPane.add(textFieldFour, 3, 1, 1, 1);
        gridPane.add(textFieldFive, 4, 1, 1, 1);
        gridPane.add(textFieldSix, 5, 1, 1, 1);
        gridPane.add(buttonSubmit, 0, 2, 2, 1);
        gridPane.add(buttonReset, 2, 2, 2, 1);
        gridPane.add(buttonQuit, 4, 2, 2, 1);

        // Set Content
        this.setContent(gridPane);

        // Generate Answer
        this.answer = generateAnswer();
        System.out.println(this.answer);

        // ======================
        // === Event Handlers ===
        // ======================

        // Button Two Submit
        buttonSubmit.setOnAction(event -> {
            if (event.getSource() == buttonSubmit) {
                buttonSubmit();
            }

            if (generalController.getStars() > 0 && (2 == (this.getTabPane().getTabs().size()))) {
                PrizesTab prizesTab = new PrizesTab(generalController.getListView(), generalController);
                this.getTabPane().getTabs().add(prizesTab);
            }

            if (generalController.getStars() > 0) {
                generalController.refreshList((Stage) this.getTabPane().getScene().getWindow());
            }
        });

        // Button Two Reset
        buttonReset.setOnAction(event -> {
            if (event.getSource() == buttonReset) {
                buttonReset();
            }
        });

        // Button Two Quit
        buttonQuit.setOnAction(event -> ((Stage) this.getTabPane().getScene().getWindow()).close());

    }

    private ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answerTwo = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            answerTwo.add(i);
        }
        Collections.shuffle(answerTwo);
        answerTwo = new ArrayList<>(answerTwo.subList(0, 6));
        return answerTwo;
    }

    private void buttonSubmit() {

        int[] guess = new int[6];
        try {
            guess[0] = Integer.parseInt(this.textFieldOne.getText());
            guess[1] = Integer.parseInt(this.textFieldTwo.getText());
            guess[2] = Integer.parseInt(this.textFieldThree.getText());
            guess[3] = Integer.parseInt(this.textFieldFour.getText());
            guess[4] = Integer.parseInt(this.textFieldFive.getText());
            guess[5] = Integer.parseInt(this.textFieldSix.getText());
        } catch (NumberFormatException e) {
            Alert integerAlert = new Alert(Alert.AlertType.INFORMATION);
            integerAlert.setTitle("Wow, those are not real guesses!");
            integerAlert.setHeaderText("All your guesses must be integers!");
            integerAlert.setContentText(null);

            integerAlert.showAndWait();
        }

        int score = gameLogic(answer, guess);

        if (score == 5 || score == 6) {
            generalController.setStars(generalController.getStars() + score);
            Alert lottoSuccess = new Alert(Alert.AlertType.INFORMATION);
            lottoSuccess.setTitle("Nice!");
            lottoSuccess.setContentText(String.format("You have guessed correctly! You now have %d stars!", generalController.getStars()));
            lottoSuccess.setHeaderText(null);
            lottoSuccess.showAndWait();
            buttonReset();
        } else {
            Alert lottoFailure = new Alert(Alert.AlertType.INFORMATION);
            lottoFailure.setTitle("Nice!");
            lottoFailure.setContentText(String.format("You have guessed %d numbers correctly, but there is no prize for this!", score));
            lottoFailure.setHeaderText(null);
            lottoFailure.showAndWait();
            buttonReset();
        }
    }

    private void buttonReset() {
        answer = generateAnswer();
        this.label.setText("Game Reset");
        System.out.println(answer);
    }

    private int gameLogic(ArrayList<Integer> answer, int[] guess) {
        int points = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (answer.get(j) == guess[i]) {
                    answer.set(j, -1);
                    points++;
                }
            }
        }
        return points;
    }
}
