package decathlon;

/**
 * Created by Lina on 2016-01-25.
 */
public class complexTimeToDouble {

    //method for converting minutes.seconds.miliseconds to seconds
    public double complexTimeToDouble(String s){
        String min = s.substring(0,s.indexOf("."));
        String sec = s.substring(s.indexOf(".")+1);
        Double finalSec = Double.parseDouble(min)*60 + Double.parseDouble(sec);
        return finalSec;
    }
}
