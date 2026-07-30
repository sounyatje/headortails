package player;
import java.util.Objects;

public abstract class Participant {
    private String name;
    private int score;

    public Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant other = (Participant) obj;
        return name.equals(other.name) && score == other.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}