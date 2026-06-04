package CoffeeMachine;

import java.util.Map;

public class CoffeeMachine {
    private IngredientInventory inventory;
    private Map<CoffeeType, CoffeeRecipe> recipes;

    public CoffeeMachine(IngredientInventory inventory) {
        this.inventory = inventory;

        CoffeeRecipe espressoRecipe = new CoffeeRecipe(CoffeeType.ESPRESSO, 50, 0, 18, 0);
        CoffeeRecipe latteRecipe = new CoffeeRecipe(CoffeeType.LATTE, 30, 150, 18, 0);
        CoffeeRecipe cappuccinoRecipe = new CoffeeRecipe(CoffeeType.CAPPUCCINO, 30, 120, 18, 0);
        CoffeeRecipe americanoRecipe = new CoffeeRecipe(CoffeeType.AMERICANO, 100, 0, 18, 0);
        recipes = Map.of(
                CoffeeType.ESPRESSO, espressoRecipe,
                CoffeeType.LATTE, latteRecipe,
                CoffeeType.CAPPUCCINO, cappuccinoRecipe,
                CoffeeType.AMERICANO, americanoRecipe
        );
    }

    public boolean makeCoffee(CoffeeType type) {
        CoffeeRecipe recipe = recipes.get(type);
        if (recipe == null) {
            System.out.println("Recipe not found for " + type);
            return false;
        }

        for (Map.Entry<IngredientType, Integer> entry : recipe.getIngredientRequirements().entrySet()) {
            if (!inventory.isIngredientAvailable(entry.getKey(), entry.getValue())) {
                System.out.println("Not enough " + entry.getKey() + " to make " + type);
                return false;
            }
        }

        for (Map.Entry<IngredientType, Integer> entry : recipe.getIngredientRequirements().entrySet()) {
            inventory.consume(entry.getKey(), entry.getValue());
        }

        System.out.println(type + " is ready!");
        return true;
    }

    public void displayInventory() {
        inventory.displayInventory();
    }

    public void refillIngredient(IngredientType type, int quantity) {
        inventory.refill(type, quantity);
    }
}
