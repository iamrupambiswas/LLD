package CoffeeMachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeRecipe {
    private CoffeeType type;

    private Map<IngredientType, Integer> ingredientRequirements;

    public CoffeeRecipe(CoffeeType type, int waterRequired, int milkRequired, int coffeeBeanRequired, int sugarRequired) {
        this.ingredientRequirements = new HashMap<>();
        this.ingredientRequirements.put(IngredientType.WATER, waterRequired);
        this.ingredientRequirements.put(IngredientType.MILK, milkRequired);
        this.ingredientRequirements.put(IngredientType.COFFEE_BEAN, coffeeBeanRequired);
        this.ingredientRequirements.put(IngredientType.SUGAR, sugarRequired);
    }

    public CoffeeType getType() {
        return type;
    }

    public Map<IngredientType, Integer> getIngredientRequirements() {
        return ingredientRequirements;
    }

}
