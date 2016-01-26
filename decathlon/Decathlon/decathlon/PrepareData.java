package decathlon;

/**
 * Created by Lina on 2016-01-23.
 */

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrepareData {

    private static String[] argv;
    private final String output;
    private String input;

    public PrepareData(String input, String output) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        this.input = input;
        this.output = output;

        //input reading-related variables
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        br = new BufferedReader(new FileReader(input));

        List<Player> playerList = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            String[] points = line.split(cvsSplitBy);

            String[] loopGames = new String[11];
            Player p1 = new Player(0,points[0],loopGames);
            p1.name = points[0];

            int totalResult = 0;
            for (int n = 1; n < 11; n++) {
                double k;
                loopGames[n] = points[n];

                double argument;
                int res = 0;

                //if track event - use track formula, else - use field formula
                if (n == 1 || n == 5 || n == 6) {
                    argument = Double.parseDouble(points[n]);
                    res = CalculatePoints.calcTrack(n, argument);
                }
                //last game result differs in format
                else if (n == 10){
                    complexTimeToDouble complexTime = new complexTimeToDouble();
                    argument = complexTime.complexTimeToDouble(points[n]);
                    res = CalculatePoints.calcTrack(n, argument);
                }
                else
                {
                    argument = Double.parseDouble(points[n]);
                    res = CalculatePoints.calcField(n, argument);
                }

                totalResult = totalResult + res;
            }

            p1.totalScore = totalResult;
            playerList.add(p1);
        }
        Collections.sort(playerList, new ScoreComparator());

        String fileExt = output.substring(output.indexOf(".")+1);

             if (fileExt.equals("xml")) {
                 WriteToXML.WriteToXML(playerList, output);
             }

    }
}
