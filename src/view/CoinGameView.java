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

    @Override
    public void start(Stage stage) {

        human = new HumanPlayer("Sounyâ");
        ai = new AIPlayer("Bot1");
        coin = new Coin();

        Button headsButton = new Button("HEADS");
        Button tailsButton = new Button("TAILS");

        headsButton.setOnAction(e -> playRound("HEADS"));
        tailsButton.setOnAction(e -> playRound("TAILS"));

        HBox buttons = new HBox(10, headsButton, tailsButton);
        VBox root = new VBox(15, resultLabel, buttons, scoreLabel);

        root.setStyle("-fx-padding: 30; -fx-font-size: 16px;");

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Coin Game");
        stage.setScene(scene);
        stage.show();

    }

}