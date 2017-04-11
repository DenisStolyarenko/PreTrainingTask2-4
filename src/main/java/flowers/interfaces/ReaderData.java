package flowers.interfaces;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;


public abstract class ReaderData {

    public abstract Map<Integer, String[]> readFile(String Path) throws ParserConfigurationException, IOException, SAXException;
}
