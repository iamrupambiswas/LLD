package ParkingLot;

import java.util.*;

public class ParkingFloor {
    private String floorId;
    private String floorName;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(String floorId, String floorName, List<ParkingSlot> slots) {
        this.floorId = floorId;
        this.floorName = floorName;
        this.parkingSlots = slots;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public boolean isSlotAvailable() {
        for(ParkingSlot slot: parkingSlots) {
            if(!slot.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    public ParkingSlot getAvailableSlot() {
        if(!isSlotAvailable()) {
            System.err.println("No available parking slots!");
            return null;
        }
        for(ParkingSlot slot: parkingSlots) {
            if(!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }

}
