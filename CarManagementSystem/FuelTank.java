package CarManagementSystem;

public class FuelTank {
    private int capacity;
    private int currentLevel;

    public FuelTank(int capacity, int currentLevel) {

        if(currentLevel > capacity) {
            throw new IllegalArgumentException("Current level cannot exceed tank capacity.");
        }
        
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public void refuel(int amount) {
        if(currentLevel + amount > capacity) {
            System.out.println("Cannot refuel beyond tank capacity.");
        } else {
            currentLevel += amount;
            System.out.println("Refueled " + amount + " units. Current level: " + currentLevel);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
