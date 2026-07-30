package game;

import java.util.Scanner;
import player.HumanPlayer;
import player.AIPlayer;
import model.Coin;

public class CoinGame {
    private HumanPlayer human;
    private AIPlayer ai;
    private Coin coin;
    private int totalRounds;

    public CoinGame (HumanPlayer human, AIPlayer ai, int totalRounds) {
        this.human= human;
        this.ai = ai;
        this.coin = new Coin ();
        this.totalRounds = totalRounds;
    }

    public void start() {
        for (int i = 1; i <= totalRounds; i++) {
            System.out.println("\nRound " + i + " :");
            play();
        }
    }

    public void play () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("heads or tails?");

        String humanChoice = scanner.nextLine().trim().toUpperCase();
        String aiChoice = ai.chooseSide();
        String result = coin.flip();
        System.out.println(ai.getName() + " chose: " + aiChoice);
        System.out.println("the coin is on: " + result);

        if(humanChoice.equals(result)) {
            human.addPoint();
            System.out.println(human.getName() + " wins");
        } else {
            System.out.println(human.getName() + " loses");
        }

        if(aiChoice.equals(result)){
            ai.addPoint();
            System.out.println(ai.getName() + " wins");
        } else {
            System.out.println(ai.getName() + " loses");
        }
        System.out.println(human.getName() + " score: " + human.getScore());
        System.out.println(ai.getName() + " score: " + ai.getScore());
    }
}
