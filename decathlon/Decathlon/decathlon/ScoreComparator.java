package decathlon;

import java.util.Comparator;

/**
 * Created by Lina on 2016-01-26.
 */
public class ScoreComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2){
        return p2.getTotalScore() - p1.getTotalScore();
    }

}
