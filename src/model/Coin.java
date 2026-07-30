package model;

public class Coin {
    private String side;

    public Coin() {
        this.side = flip();
    }
    public String getSide() {
        return side;
    }
    public String flip() {
        double random = Math.random();
        if (random < 0.5) {
            side = "HEADS";
        } else {
            side = "TAILS";
        }
        return side;
    }

}
