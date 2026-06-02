package Vehicle;

abstract class Vehicle {

    private int price;
    private boolean isElectric;
    private String color;

    public Vehicle(int price, boolean isElectric, String color) {
        this.price = price;
        this.isElectric = isElectric;
        this.color = color;
    }

    abstract void start();
    abstract void stop();

    void getDetails() {
        System.out.println("Price: " + price);
        System.out.println("Is Electric: " + isElectric);
        System.out.println("Color: " + color);
    }   
}


class Car extends Vehicle {
    public Car(int price, boolean isElectric, String color) {
        super(price, isElectric, color);
    }

    @Override
    public void start() {
        System.out.println("Car is starting!");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping!");
    }
}