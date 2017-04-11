package services;

import flowers.interfaces.ReaderData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFromXML extends ReaderData{

    public Map<Integer, String[]> readFile(String fileXMLPath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(fileXMLPath));
        document.normalizeDocument();
        Element root = document.getDocumentElement();
        NodeList flowers = root.getElementsByTagName("Flower");
        Map<Integer,String[]> flowerValueMap = new HashMap<>();
        int keyMap = 0;
        for (int i = 0; i < flowers.getLength(); i++) {
            Element item = (Element) flowers.item(i);
            item.getTagName();
            String id = item.getAttribute("id");
            Element name = (Element) item.getElementsByTagName("name").item(0);
            Element color = (Element) item.getElementsByTagName("color").item(0);
            Element length = (Element) item.getElementsByTagName("length").item(0);
            Element price = (Element) item.getElementsByTagName("price").item(0);
            String[] mas = {name.getTextContent(),color.getTextContent(),length.getTextContent(),price.getTextContent()};
            flowerValueMap.put(keyMap++,mas);
        }
        return flowerValueMap;
    }


}
