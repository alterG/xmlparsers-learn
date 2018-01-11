package alterg.parser.dom;

import alterg.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Note: all nodes elements have text nodes elements
 */
public class Application {

    public static void main(String[] args) throws URISyntaxException {
        String filepath = "languages.xml";
        File source = new File(Main.getResource(filepath));
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(source);
            document.normalize();
            String rootName = document.getDocumentElement().getNodeName();
            System.out.println(rootName);
            NodeList nodeList = document.getElementsByTagName("Language");
            List<Language> nodes = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                nodes.add(parse(nodeList.item(i)));
            }
            nodes.stream()
                .forEach(System.out::println);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static Language parse(Node node) {
        Language lang = new Language();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;
            lang.setAge(Integer.parseInt(getTagValue("age", elem)));
            lang.setName(getTagValue("name", elem));
        }
        return lang;
    }

    private static String getTagValue(String tag, Element element) {
        return element.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue();
    }
}
