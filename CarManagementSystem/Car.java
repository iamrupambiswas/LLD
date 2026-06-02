package CarManagementSystem;

import java.util.List;

public class Car {
    private String company;
    private String model;
    private Engine engine;
    private FuelTank fuelTank;
    private Battery battery;
    private List<Wheel> wheels;

    public Car(String company, String model, Engine engine, FuelTank fuelTank, Battery battery, List<Wheel> wheels) {

        if(wheels.size() != 4) {
            throw new IllegalArgumentException("A car must have exactly 4 wheels.");
        }

        this.engine = engine;
        this.fuelTank = fuelTank;
        this.battery = battery;
        this.wheels = wheels;
        this.company = company;
        this.model = model;
    }

    public void refuel(int amount) {
        fuelTank.refuel(amount);
    }

    public void chargeBattery(int amount) {
        battery.charge(amount);
    }

    public void inflateWheels(int wheelNumber, int amount) {
        if (wheelNumber < 1 || wheelNumber > 4) {
            throw new IllegalArgumentException("Invalid wheel number. Please specify a wheel between 1 and 4.");
        }
        wheels.get(wheelNumber - 1).inflate(amount);
    }

    public void displayCarInfo() {
        System.out.println("Brand: " + company);
        System.out.println("Model: " + model);
        
        System.out.println("Engine Number: " + engine.getNumber());
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Engine Horsepower: " + engine.getHorsepower());

        System.out.println("Fuel Tank Capacity: " + fuelTank.getCapacity());
        System.out.println("Current Fuel Level: " + fuelTank.getCurrentLevel());

        System.out.println("Battery Percentage: " + battery.getPercentage());

    }
}
