package ShoppingCart;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cart {

    private Map<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product item) {
        if(items.containsKey(item)) {
            items.put(item, items.get(item)+1);
        } else {
            items.put(item, 1);
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void removeItem(int id) {
        for(Map.Entry<Product, Integer> entry : items.entrySet()) {
            if(entry.getKey().getId() == id) {
                int quantity = entry.getValue();
                if(quantity > 1) {
                    items.put(entry.getKey(), quantity - 1);
                } else {
                    items.remove(entry.getKey());
                }
            }
        }

    }
    
}
