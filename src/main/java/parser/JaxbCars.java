package parser;

import entity.Car;
import entity.Cars;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbCars extends AbstractParserForCar{

    public void parse() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cars.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Cars emps = (Cars) jaxbUnmarshaller.unmarshal(new File("Auto.xml"));

    }
}
