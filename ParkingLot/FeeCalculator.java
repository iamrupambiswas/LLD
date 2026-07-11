package ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class FeeCalculator {
    private final Map<VehicleType, Integer> hourlyCharges = new HashMap<>();

    public FeeCalculator() {
        hourlyCharges.put(VehicleType.CAR, 100);
        hourlyCharges.put(VehicleType.BIKE, 50);
        hourlyCharges.put(VehicleType.TRUCK, 250);
    }

    public int getCharges(Vehicle vehicle, int hours) {
        int totalCharges = hourlyCharges.get(vehicle.getVehicleType()) * hours;
        return totalCharges;
    }

    public void changeCharges(VehicleType type, int newPrice) {
        hourlyCharges.put(type, newPrice);
    }
}
