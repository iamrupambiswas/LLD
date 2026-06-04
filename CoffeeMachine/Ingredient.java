package CoffeeMachine;

public class Ingredient {
    private IngredientType type;
    private int quantity;
    private int capacity;

    public Ingredient(int quantity, int capacity, IngredientType type) {

        if(quantity > capacity) {
            throw new IllegalArgumentException("Quantity cannot exceed capacity");
        }

        this.quantity = quantity;
        this.capacity = capacity;
        this.type = type;
    }

    public IngredientType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void use(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Invalid amount to use");
        }
    }

    public void refill(int amount) {
        if (quantity + amount > capacity) {
            throw new IllegalArgumentException("Refill amount exceeds capacity");
        }
        quantity += amount;
    }
}
