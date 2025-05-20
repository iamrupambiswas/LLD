abstract class Pen {
    String brand;
    float price;
    String color;

    public Pen(String brand, float price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public abstract void write();
    public abstract void refill();

    public void getDetails() {
        System.out.println("Brand : " + this.brand);
        System.out.println("Price : " + this.price);
        System.out.println("Color : " + this.color);
    }
}

class BallPen extends Pen {

    public BallPen(String brand, float price, String color) {
        super(brand, price, color);
    }

    @Override
    public void write() {
        System.out.println("Writing with ballpen!");
    }

    @Override
    public void refill() {
        System.out.println("Refilling the ballpen!");
    }
}