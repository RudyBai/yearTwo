import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

class GuessingGame extends Tab {
    private TextField textField;
    private Label label;
    private Button buttonSubmit;
    private Button buttonReset;
    private int answer;
    private int streak;
    private int numberOfGuesses;

    private GeneralController generalController;

    GuessingGame(GeneralController generalController) {

        // General Controller
        this.generalController = generalController;
        // Set Title
        this.setText("Guessing Game");

        // Instantiate elements
        this.label = new Label("Guess a number 1 - 50");
        this.textField = new TextField();
        this.buttonSubmit = new Button("Submit");
        this.buttonReset = new Button("Reset");
        Button buttonQuit = new Button("Quit");
        this.streak = 0;
        this.numberOfGuesses = 4;

        // Instantiate GridPane
        GridPane gridPane = new GridPane();

        // GridPane Layout
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setHgap(20);

        // GridPane Children
        gridPane.add(label, 0, 1, 3, 1);
        gridPane.add(textField, 0, 0, 3, 1);
        gridPane.add(buttonSubmit, 0, 2, 1, 1);
        gridPane.add(buttonReset, 1, 2, 1, 1);
        gridPane.add(buttonQuit, 2, 2, 1, 1);

        // Set Content
        this.setContent(gridPane);

        // Generate Answer
        this.answer = generateAnswerOne();
        System.out.println(this.answer);

        // ======================
        // === Event Handlers ===
        // ======================

        // Button One Submit
        buttonSubmit.setOnAction(actionEvent -> {
            if (actionEvent.getSource() == buttonSubmit) {
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

        // Button One Reset
        buttonReset.setOnAction(actionEvent -> {
            if (actionEvent.getSource() == buttonReset) {
                buttonReset();
            }
        });

        // Button One Quit
        buttonQuit.setOnAction(event -> ((Stage) this.getTabPane().getScene().getWindow()).close());
    }

    private int generateAnswerOne() {
        Random random = new Random();
        return random.nextInt(49) + 1;
    }

    private void buttonSubmit() {
        try {
            int guess = Integer.parseInt(this.textField.getText());
            if (gameLogic(answer, guess) == 0) {


                this.streak++;
                if (this.streak > 4) {
                    generalController.setStars(generalController.getStars() + 3);
                } else {
                    generalController.setStars(generalController.getStars() + 2);                }

                Alert gameOneSuccess = new Alert(Alert.AlertType.INFORMATION);
                gameOneSuccess.setTitle("Nice!");
                gameOneSuccess.setContentText(String.format("You have guessed correctly! You now have %d stars!", generalController.getStars()));
                gameOneSuccess.setHeaderText(null);
                gameOneSuccess.showAndWait();
                buttonReset();

            } else if (gameLogic(answer, guess) == 1) {
                label.setText(String.format("Guess higher, you have %d guesses left.", 3 - numberOfGuesses));
            } else if (gameLogic(answer, guess) == 2) {
                label.setText(String.format("Guess lower, you have %d guesses left.", 3 - numberOfGuesses));
            }

            this.numberOfGuesses++;
        } catch (NumberFormatException nfe) {
            label.setText("Must be integer");
        }
        if (numberOfGuesses == 4) {
            streak = 0;
            Alert resetAlert = new Alert(Alert.AlertType.INFORMATION);
            resetAlert.setTitle("No more guesses!");
            resetAlert.setContentText("You have run out of guesses and the game will now reset!");
            buttonReset();
        }
    }
    private void buttonReset() {
        this.label.setText("Game reset");
        numberOfGuesses = 0;
        answer = generateAnswerOne();
        System.out.println(answer);
    }

    private int gameLogic(int answer, int guess) {
        if (answer == guess) {
            return 0;
        } else if (answer > guess) {
            return 1;
        } else {
            return 2;
        }
    }
}
