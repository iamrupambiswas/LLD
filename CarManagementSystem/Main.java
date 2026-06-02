package CarManagementSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("Eng001", EngineType.PETROL, 1500);

        FuelTank fuelTank = new FuelTank(50, 10);

        Wheel wheel1 = new Wheel(1, 30);
        Wheel wheel2 = new Wheel(2, 30);
        Wheel wheel3 = new Wheel(3, 30);
        Wheel wheel4 = new Wheel(4, 30);

        Battery battery = new Battery(100);

        Car car = new Car("Tata", "Safari", engine, fuelTank, battery, List.of(wheel1, wheel2, wheel3, wheel4));
        car.displayCarInfo();
    }
}
