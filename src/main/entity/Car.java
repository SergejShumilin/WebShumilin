package entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@Data
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)

public class Car {
    @XmlAttribute
    private int id;
    private String model;
    private String production;
    private int price;
    private double fuelConsumption;

    public static class Builder {
        int i = 0;
        String mod = null;
        String prod = null;
        int pr = 0;
        double fuel = 0;

        public Builder buildId(int i) {
            this.i = i;
            return this;
        }

        public Builder buildModel(String mod) {
            this.mod = mod;
            return this;
        }

        public Builder buildProduction(String prod) {
            this.prod = prod;
            return this;
        }

        public Builder buildPrice(int pr) {
            this.pr = pr;
            return this;
        }

        public Builder buildFuelConsumption(double fuel) {
            this.fuel = fuel;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.setId(i);
            car.setModel(mod);
            car.setProduction(prod);
            car.setPrice(pr);
            car.setFuelConsumption(fuel);
            return car;
        }
    }
}
