package CarManagementSystem;

public class Wheel {

    private int number;
    private int pressure;

    public Wheel(int number, int pressure) {
        this.number = number;
        this.pressure = pressure;
    }

    public void inflate(int amount) {
        pressure += amount;
        System.out.println("Inflated wheel " + number + " by " + amount + " units. Current pressure: " + pressure);
    }
}
