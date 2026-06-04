package CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        IngredientInventory inventory = new IngredientInventory(
            new Ingredient(100, 200, IngredientType.WATER),
            new Ingredient(50, 100, IngredientType.MILK),
            new Ingredient(30, 50, IngredientType.COFFEE_BEAN),
            new Ingredient(20, 50, IngredientType.SUGAR)
        );

        CoffeeMachine machine = new CoffeeMachine(inventory);

        machine.displayInventory();

        machine.makeCoffee(CoffeeType.ESPRESSO);

        machine.displayInventory();
    }
}
