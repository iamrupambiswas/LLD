package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Item> items;
    private float balance;

    public VendingMachine() {
        this.items = new HashMap<>();
        this.balance = 0.0f;
    }

    public void addItems(Item item) {
        items.put(item.getName(), item);
    }

    public void insertCoin(float amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Inserted: "+amount+", Total balance: " + balance);
        } else {
            System.out.println("Invalid coin!");
        }
    }

    public void selectItem(String name) {
        if (!items.containsKey(name)) {
            System.out.println("Item not available!");
            return;
        }

        Item item = items.get(name);

        if(item.getQuantity() <= 0) {
            System.out.println("Item out of stock!");
        } else if (item.getPrice() > balance) {
            System.out.println("Insufficient balance!");
        } else {
            item.dispense();
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());
        }
    }

    public void returnChange() {
        if(balance > 0) {
            System.out.println("Returning balance: " + balance);
            balance = 0;
        } else {
            System.out.println("No amount to return!");
        }
    }
    
}
