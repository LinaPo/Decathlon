package decathlon;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class Start{


    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
       String input = "input.txt";
        String output = "results.xml";

       new PrepareData(input, output);


    }

};

