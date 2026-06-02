package Vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(20000, false, "Sky Blue");
        car.getDetails();
        car.start();
        car.stop();
    }
}
