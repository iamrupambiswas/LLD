package ParkingLot;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketNumber;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public Ticket(int ticketNumber, LocalDateTime entryTime, Vehicle vehicle, ParkingSlot slot) {
        this.ticketNumber = ticketNumber;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = slot;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
