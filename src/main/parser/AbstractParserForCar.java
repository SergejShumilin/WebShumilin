package parser;

import entity.Car;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public abstract class AbstractParserForCar {
    static HashSet<Car> cars = new HashSet<>();

    public abstract void parse() throws JAXBException, ParserConfigurationException, SAXException, IOException;

    public  HashSet<Car> getCars() {
        return cars;
    }
}
