package ParkingLot;

abstract class Vehicle {
    private VehicleType type;
    private String name;
    private String number;

    public Vehicle(VehicleType type, String name, String number) {
        this.type = type;
        this.name = name;
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return this.type;
    }

    public String getVehicleName() {
        return this.name;
    }

    public String getVehicleNumber() {
        return this.number;
    }
}
