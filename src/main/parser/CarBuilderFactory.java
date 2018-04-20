package parser;

public class CarBuilderFactory {
    private enum TypeParser {
        DOM, JAXB
    }
    public static AbstractParserForCar createCarBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new CarsDOMBuilder();
            case JAXB:
                return new JaxbCars();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }
}
