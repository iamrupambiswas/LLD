package ParkingLot;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public String getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean occupy(Vehicle vehicle) {
        if(this.isOccupied) {
            return false;
        }
        this.vehicle = vehicle;
        return this.isOccupied = true;
    }

    public boolean vacant() {
        if(!this.isOccupied) {
            return false;
        }
        this.vehicle = null;
        return this.isOccupied = false;
    }
}
