package CoffeeMachine;

import java.util.Map;

public class CoffeeRecipe {

    private final CoffeeType type;

    private final Map<IngredientType, Integer> ingredientRequirements;

    private CoffeeRecipe(Builder builder) {
        this.type = builder.type;
        this.ingredientRequirements = builder.ingredientRequirements;
    }

    public static class Builder {
        private CoffeeType type;
        private Map<IngredientType, Integer> ingredientRequirements;

        public Builder(CoffeeType type) {
            this.type = type;
            this.ingredientRequirements = new java.util.HashMap<>();
        }

        public Builder addIngredient(IngredientType ingredientType, int quantity) {
            this.ingredientRequirements.put(ingredientType, quantity);
            return this;
        }

        public CoffeeRecipe build() {
            return new CoffeeRecipe(this);
        }
    }

    public CoffeeType getType() {
        return type;
    }

    public Map<IngredientType, Integer> getIngredientRequirements() {
        return ingredientRequirements;
    }

}
