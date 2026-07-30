package principal;

import player.HumanPlayer;
import player.AIPlayer;

public class Main{
    public static void main (String[] args){
        HumanPlayer player1 = new HumanPlayer("Sounyâ");
        AIPlayer bot1 = new AIPlayer("bot1");
        System.out.println(player1.getName() + " -score: " + player1.getScore());
        bot1.announceResult();
    }
}