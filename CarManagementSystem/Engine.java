package CarManagementSystem;

public class Engine {
    private String number;
    private EngineType type;
    private int horsepower;

    public Engine(String number, EngineType type, int horsepower) {
        this.number = number;
        this.type = type;
        this.horsepower = horsepower;
    }

    public String getNumber() {
        return number;
    }

    public EngineType getType() {
        return type;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
