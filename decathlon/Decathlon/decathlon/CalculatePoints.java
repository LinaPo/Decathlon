package decathlon;

import static java.lang.Math.pow;

/**
 * Created by Lina on 2016-01-23.
 */
public class CalculatePoints {
    static double[] paramA = {0, 25.4347, 0.14354, 51.39, 0.8465, 1.53775,5.74352, 12.91, 0.2797, 10.14, 0.03768};
    static double[] paramB = {0, 18, 220, 1.5, 75, 82, 28.5, 4, 100, 7, 480};
    static double[] paramC = {0, 1.81, 1.4, 1.05, 1.42, 1.81, 1.92, 1.1, 1.35, 1.08, 1.85};

    //for track events
    public static int calcTrack(int k, double p){
            int result = (int) Math.round(paramA[k]*(pow((paramB[k]-p),paramC[k])));
            return result;
        }
    //for field events
    public static int calcField(int k, double p){
        int result = (int) Math.round(paramA[k]*(pow((p-paramB[k]),paramC[k])));
        return result;
    }

}
