package player;

public class AIPlayer extends Participant {
    public AIPlayer(String name) {
        super(name, 0);
    }
    public String chooseSide() {
        double random = Math.random();
        if (random < 0.5) {
            return "HEADS";
        } else {
            return "TAILS";
        }
    }
}
