package servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;
import parser.AbstractParserForCar;
import parser.CarBuilderFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class ServletForCars extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ServletForCars.class);

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        String log4jLocation = context.getRealPath(config.getInitParameter("log4j"));
        PropertyConfigurator.configure(log4jLocation);
        LOG.info("test");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doParse(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doParse(req, resp);
    }

    private void doParse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parserType = req.getParameter("choice");
        LOG.info(parserType);
        AbstractParserForCar parser = CarBuilderFactory.createCarBuilder(parserType);
        req.setAttribute("result", parser.getCars());
        req.setAttribute("message", parserType);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);

    }
}
