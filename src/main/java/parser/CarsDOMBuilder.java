package parser;

import entity.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CarsDOMBuilder extends AbstractParserForCar {

    private static CarsDOMBuilder instance = null;

    CarsDOMBuilder() {
    }

    public static synchronized CarsDOMBuilder getInstance() {
        if (instance == null) {
            instance = new CarsDOMBuilder();
        }
        return instance;
    }

    public void parse() throws ParserConfigurationException, org.xml.sax.SAXException, IOException {

        List<Car> cars = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("Auto.xml"));

        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("car");


        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Car car = createCar((Element) node);
                cars.add(car);
            }
        }
    }

    private Car createCar(Element node) {
        Element eElement = node;
        Car car = new Car.Builder().buildId(Integer.parseInt(eElement.getAttribute("id")))
                .buildFuelConsumption(Double.parseDouble(eElement.getElementsByTagName("fuelConsumption").item(0).getTextContent()))
                .buildModel(eElement.getElementsByTagName("model").item(0).getTextContent())
                .buildPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()))
                .buildProduction(eElement.getElementsByTagName("production").item(0).getTextContent())
                .build();

        return car;
    }


}
