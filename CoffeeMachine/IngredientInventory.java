package CoffeeMachine;

public class IngredientInventory {
    private Ingredient water;
    private Ingredient milk;
    private Ingredient coffeeBean;
    private Ingredient sugar;

    public IngredientInventory(Ingredient water, Ingredient milk, Ingredient coffeeBean, Ingredient sugar) {
        this.water = water;
        this.milk = milk;
        this.coffeeBean = coffeeBean;
        this.sugar = sugar;
    }

    public boolean isIngredientAvailable(IngredientType type, int requiredQuantity) {
        switch (type) {
            case WATER:
                return water.getQuantity() >= requiredQuantity;
            case MILK:
                return milk.getQuantity() >= requiredQuantity;
            case COFFEE_BEAN:
                return coffeeBean.getQuantity() >= requiredQuantity;
            case SUGAR:
                return sugar.getQuantity() >= requiredQuantity;
            default:
                return false;
        }
    }

    public void refill(IngredientType type, int quantity) {
        switch(type) {
            case WATER:
                water.refill(quantity);
                break;
            case MILK:
                milk.refill(quantity);
                break;
            case COFFEE_BEAN:
                coffeeBean.refill(quantity);
                break;
            case SUGAR:
                sugar.refill(quantity);
                break;
        }
    }

    public void consume(IngredientType type, int quantity) {
        switch(type) {
            case WATER:
                water.use(quantity);
                break;
            case MILK:
                milk.use(quantity);
                break;
            case COFFEE_BEAN:
                coffeeBean.use(quantity);
                break;
            case SUGAR:
                sugar.use(quantity);
                break;
        }
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        System.out.println("Water: " + water.getQuantity() + "/" + water.getCapacity());
        System.out.println("Milk: " + milk.getQuantity() + "/" + milk.getCapacity());
        System.out.println("Coffee Beans: " + coffeeBean.getQuantity() + "/" + coffeeBean.getCapacity());
        System.out.println("Sugar: " + sugar.getQuantity() + "/" + sugar.getCapacity());
    }
}
