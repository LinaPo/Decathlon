package decathlon;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Lina on 2016-01-24.
 */
public class Player implements Serializable, Comparator<Player> {

    public int totalScore;
    public String name;
    public String[] games;


    public Player(int totalScore, String name, String[] games) {
        this.totalScore = totalScore;
        this.name = name;
        this.games = games;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGames() {
        return games;
    }

    public void setGames(String[] games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Player{" + "totalScore=" + totalScore + ", name=" + name + ", game1=" +  games[1] + ", game2=" + games[2] + ", game3=" + games[3] + '}';
    }


    @Override
    public int compare(Player p, Player o) {
        return p.getTotalScore() - o.getTotalScore();

    }
}
