package CarManagementSystem;

public class Battery {
    private int percentage;

    public Battery(int percentage) {

        if(percentage > 100) {
            throw new IllegalArgumentException("Battery percentage cannot exceed 100%.");
        }
        
        this.percentage = percentage;
    }

    public void charge(int amount) {
        if(percentage + amount > 100) {
            System.out.println("Cannot charge beyond 100%.");
        } else {
            percentage += amount;
            System.out.println("Charged " + amount + "%. Current percentage: " + percentage + "%");
        }
    }

    public int getPercentage() {
        return percentage;
    }
}
