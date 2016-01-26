package decathlon;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Lina on 2016-01-25.
 */
public class TestWriteToXML {

    @Test
    public void TestWriteXMLFile(){
        File file = new File("C:/Users/Lina/IdeaProjects/Decathlon/results.xml");
        assertTrue(file.exists());
    }


}
