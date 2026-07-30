package principal;

import player.HumanPlayer;
import player.AIPlayer;
import game.CoinGame;

public class Main{
    public static void main (String[] args){
        HumanPlayer player1 = new HumanPlayer("Sounyâ");
        AIPlayer bot1 = new AIPlayer("bot1");

        CoinGame round = new CoinGame(player1, bot1);
        round.play();
        System.out.println(player1.getName() + " -score: " + player1.getScore());
        bot1.announceResult();
    }
}