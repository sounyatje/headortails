package view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.HumanPlayer;
import player.AIPlayer;
import model.Coin;

//Scene (le contenu), Button/Label (les contrôles), HBox/VBox (les containers), Stage (la fenêtre).

public class CoinGameView extends Application {
    private HumanPlayer human;
    private AIPlayer ai;
    private Coin coin;

    private int currentRound = 1;
    private int totalRounds = 3;

    private Label resultLabel = new Label("Choose HEADS or TAILS");
    private Label scoreLabel = new Label("Score - " );

    private Button headsButton;
    private Button tailsButton;


    @Override
    public void start(Stage stage) {

        human = new HumanPlayer("Sounyâ");
        ai = new AIPlayer("Bot1");
        coin = new Coin();

        headsButton = new Button("HEADS");
        tailsButton = new Button("TAILS");

        headsButton.setOnAction(e -> playRound("HEADS"));
        tailsButton.setOnAction(e -> playRound("TAILS"));

        HBox buttons = new HBox(10, headsButton, tailsButton);
        VBox root = new VBox(15, resultLabel, buttons, scoreLabel);

        root.setStyle("-fx-padding: 30; -fx-font-size: 16px;");

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Coin Game");
        stage.setScene(scene);
        stage.show();

    }

    private void playRound(String humanChoice) {
        String aiChoice = ai.chooseSide();
        String result = coin.flip();

        String feedback = ai.getName() + " chose: " + aiChoice + "\n";
        feedback += "The coin is on: " + result + "\n";

        if (humanChoice.equals(result)) {
            human.addPoint();
            feedback += human.getName() + " wins\n";
        } else {
            feedback += human.getName() + " loses\n";
        }

        if (aiChoice.equals(result)) {
            ai.addPoint();
            feedback += ai.getName() + " wins";
        } else {
            feedback += ai.getName() + " loses";
        }
        resultLabel.setText(feedback);
        scoreLabel.setText(human.getName() + ": " + human.getScore()
                + " | " + ai.getName() + ": " + ai.getScore());
        currentRound++;
        if (currentRound > totalRounds) {
            headsButton.setDisable(true);
            tailsButton.setDisable(true);
            String finalMessage;
            if (human.getScore() > ai.getScore()) {
                finalMessage = human.getName() + " wins the game!";
            } else if (ai.getScore() > human.getScore()) {
                finalMessage = ai.getName() + " wins the game!";
            } else {
                finalMessage = "It's a tie!";
            }

            resultLabel.setText(resultLabel.getText() + "\n\n" + finalMessage);

        }

    }


}