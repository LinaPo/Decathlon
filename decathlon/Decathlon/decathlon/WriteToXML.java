package decathlon;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

/**
 * Created by Lina on 2016-01-26.
 */
public class WriteToXML {
    public static void WriteToXML(List<Player> playerList, String output) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        //XML content generation
        Element rootElement = doc.createElement("Results");
        doc.appendChild(rootElement);

        for(int i=0; i < playerList.size(); i++) {

            Element staff = doc.createElement("Player");
            rootElement.appendChild(staff);

            Attr attr = doc.createAttribute("rank");
            attr.setValue(String.valueOf(i + 1));
            staff.setAttributeNode(attr);

            Element firstName = doc.createElement("Name");
            firstName.appendChild(doc.createTextNode(playerList.get(i).name));
            staff.appendChild(firstName);

            Element totalScore = doc.createElement("TotalScore");
            totalScore.appendChild(doc.createTextNode(String.valueOf(playerList.get(i).totalScore)));
            staff.appendChild(totalScore);

            Element game = doc.createElement("GameResults");
            staff.appendChild(game);

            for (int g = 1; g < 11; g++) {

                String gameNo = "Game" + String.valueOf(g);
                Element result = doc.createElement(gameNo);
                result.appendChild(doc.createTextNode(String.valueOf(playerList.get(i).games[g])));
                game.appendChild(result);
            }
        }

        //write the content to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
