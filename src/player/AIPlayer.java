package player;

public class AIPlayer extends Participant implements Notifiable {
    public AIPlayer(String name) {
        super(name, 0);
    }
    public String chooseSide() { // ← ici, "public" est OBLIGATOIRE, sinon accès limité

        double random = Math.random();
        if (random < 0.5) {
            return "HEADS";
        } else {
            return "TAILS";
        }
    }
    @Override
    public void announceResult() {
        System.out.println(getName() + " chose : " + chooseSide());
    }
}
