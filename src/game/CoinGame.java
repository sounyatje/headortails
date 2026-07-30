package game;

import java.util.Scanner;
import player.HumanPlayer;
import player.AIPlayer;
import model.Coin;

public class CoinGame {
    private HumanPlayer human;
    private AIPlayer ai;
    private Coin coin;

    public CoinGame (HumanPlayer human, AIPlayer ai) {
        this.human= human;
        this.ai = ai;
        this.coin = new Coin ();
    }

    public void play () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("heads or tails?");


        String aiChoice = ai.chooseSide();
        String result = coin.flip();

        System.out.println("the coin is on: " + result);
        String humanChoice = scanner.nextLine().trim().toUpperCase();

        if(humanChoice.equals(result)) {
            human.addPoint();
            System.out.println(human.getName() + "wins");
        } else {
            System.out.println(human.getName() + "loses");
        }

        if(aiChoice.equals(result)){
            ai.addPoint();
            System.out.println(ai.getName() + "wins");
        } else {
            System.out.println(ai.getName() + "loses");
        }
    }
}
