package ShoppingCart;

public class Main {
    
    public static void main(String[] args) {
        Product prod1 = new Product(0, "Pen", 50);
        Product prod2 = new Product(1, "Notebook", 100);

        User user = new User("Rupam");

        user.addItem(prod1);
        user.addItem(prod2);

        user.viewCart();
        user.getTotal();

        user.removeItem(0);
        user.viewCart();
    }

}
