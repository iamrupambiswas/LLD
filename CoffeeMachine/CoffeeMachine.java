package CoffeeMachine;

import java.util.Map;

public class CoffeeMachine {
    private static CoffeeMachine instance;
    private final IngredientInventory inventory;
    private final Map<CoffeeType, CoffeeRecipe> recipes;

    private CoffeeMachine(IngredientInventory inventory) {
        this.inventory = inventory;

        CoffeeRecipe espressoRecipe = new CoffeeRecipe.Builder(CoffeeType.ESPRESSO)
                .addIngredient(IngredientType.WATER, 50)
                .addIngredient(IngredientType.COFFEE_BEAN, 18)
                .build();
        CoffeeRecipe latteRecipe = new CoffeeRecipe.Builder(CoffeeType.LATTE)
                .addIngredient(IngredientType.WATER, 30)
                .addIngredient(IngredientType.MILK, 150)
                .addIngredient(IngredientType.COFFEE_BEAN, 18)
                .build();
        CoffeeRecipe cappuccinoRecipe = new CoffeeRecipe.Builder(CoffeeType.CAPPUCCINO)
                .addIngredient(IngredientType.WATER, 30)
                .addIngredient(IngredientType.MILK, 120)
                .addIngredient(IngredientType.COFFEE_BEAN, 18)
                .build();
        CoffeeRecipe americanoRecipe = new CoffeeRecipe.Builder(CoffeeType.AMERICANO)
                .addIngredient(IngredientType.WATER, 100)
                .addIngredient(IngredientType.COFFEE_BEAN, 18)
                .build();

        recipes = Map.of(
                CoffeeType.ESPRESSO, espressoRecipe,
                CoffeeType.LATTE, latteRecipe,
                CoffeeType.CAPPUCCINO, cappuccinoRecipe,
                CoffeeType.AMERICANO, americanoRecipe
        );
    }

    public static CoffeeMachine getInstance(IngredientInventory inventory) {
        if (instance == null) {
            instance = new CoffeeMachine(inventory);
        }
        return instance;
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
