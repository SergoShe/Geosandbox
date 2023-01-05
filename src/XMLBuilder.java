import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class XMLBuilder {

    public void toXML(HashMap<String, Shape> shapeList, String nameFile) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("shapeList");
        document.appendChild(rootElement);
        shapeList.values().forEach(x -> rootElement.appendChild(getShape(document, x)));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(new File(nameFile + ".xml"));
        transformer.transform(source, file);
    }

    public HashMap<String, Shape> fromXML() {
        HashMap<String, Shape> shapeList = new LinkedHashMap<>();
        //для следующего этапа
        return shapeList;
    }

    private Node getShape(Document document, Shape shape) {
        Element shapeElement = document.createElement("shape");
        shapeElement.setAttribute("type", shape.getType().toString());
        Element nameShapeElement = document.createElement("name");
        nameShapeElement.appendChild(document.createTextNode(shape.getName()));
        shapeElement.appendChild(nameShapeElement);
        switch (shape.getType()) {
            case RECTANGLE -> {
                Rectangle rectangle = (Rectangle) shape;
                Element sides = document.createElement("sides");
                Arrays.stream(rectangle.getSides()).forEach(x -> sides.appendChild(getSide(document, x)));
                shapeElement.appendChild(sides);
            }
            case TRIANGLE -> {
                Triangle triangle = (Triangle) shape;
                Element sides = document.createElement("sides");
                Arrays.stream(triangle.getSides()).forEach(x -> sides.appendChild(getSide(document, x)));
                shapeElement.appendChild(sides);
            }
            case CIRCLE -> {
                Circle circle = (Circle) shape;
                Element radius = document.createElement("radius");
                radius.appendChild(document.createTextNode(String.valueOf(circle.getRadius())));
                shapeElement.appendChild(radius);
            }
        }
        return shapeElement;
    }

    private Node getSide(Document document, double side) {
        Element sideElement = document.createElement("side");
        sideElement.appendChild(document.createTextNode(String.valueOf(side)));
        return sideElement;
    }
}
