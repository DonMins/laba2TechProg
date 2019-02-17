import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XmlParser {
    public static Circle getXmlData() throws ParserConfigurationException, IOException, SAXException {

            File inputFile = new File("state.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Circle circle = new Circle();
            NodeList nList = doc.getElementsByTagName("circle");

                Node nNode = nList.item(0);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String st =  eElement.getElementsByTagName("radius").item(0).getTextContent();
                    double radius = Double.parseDouble(st);
                    st =  eElement.getElementsByTagName("x").item(0).getTextContent();
                    double x = Double.parseDouble(st);
                    st =  eElement.getElementsByTagName("y").item(0).getTextContent();
                    double y = Double.parseDouble(st);
                    circle = new Circle(radius, x, y);
                }
                return circle;
            }

    }


