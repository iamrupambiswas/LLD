package ShoppingCart;

import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private Cart cart;

    public User(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void addItem(Product item) {
        cart.addItem(item);
    }

    public void viewCart() {
        Map<Product, Integer> cartItems = cart.getItems();

        for(Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + " x " + quantity);
        }
    }
    
    public void getTotal() {
        Map<Product, Integer> cartItems = cart.getItems();
        double total = 0;

        for(Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        System.out.println("Total: $" + total);
    }

    public void removeItem(int id) {
        cart.removeItem(id);
    }
}