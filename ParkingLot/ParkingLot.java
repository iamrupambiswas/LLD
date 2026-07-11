package ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalTime;

public class ParkingLot {

    Set<ParkingFloor> parkingFloors;
    Map<Integer, Ticket> activeTickets;
    private static int nextTicketId = 1;
    FeeCalculator feeCalculator;

    public ParkingLot(Set<ParkingFloor> floors) {
        this.parkingFloors = floors;
        activeTickets = new HashMap<>();
        feeCalculator = new FeeCalculator();
    }

    public boolean isFloorAvailable() {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.isSlotAvailable()) {
                return true;
            }
        }
        return false;
    }

    public ParkingFloor getAvailableFloor() {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.isSlotAvailable()) {
                return parkingFloor;
            }
        }
        System.out.println("No floor is empty!");
        return null;
    }

    public boolean isSlotAvailable() {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.isSlotAvailable()) {
                return true;
            }
        }
        return false;
    }

    public ParkingSlot getAvailableSlot() {
        if (!isSlotAvailable()) {
            System.err.println("No available parking slots!");
            return null;
        }
        ParkingFloor availableFloor = getAvailableFloor();
        if (availableFloor != null) {
            return availableFloor.getAvailableSlot();
        }
        return null;
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingSlot slot) {
        if (slot.isOccupied()) {
            return null;
        }
        Ticket newTicket = new Ticket(nextTicketId, LocalDateTime.now(), vehicle, slot);
        activeTickets.put(nextTicketId++, newTicket);
        slot.occupy(vehicle);
        return newTicket;
    }

    public Vehicle unparkVehicle(Ticket ticket) {
        if (ticket == null || !activeTickets.containsKey(ticket.getTicketNumber())) {
            System.out.println("Invalid ticket!");
            return null;
        }

        LocalDateTime exitTime = LocalDateTime.now();
        long hoursBetween = java.time.temporal.ChronoUnit.HOURS.between(ticket.getEntryTime(), exitTime);
        int totalHours = Math.max((int) hoursBetween, 1);

        int charges = feeCalculator.getCharges(ticket.getVehicle(), totalHours);
        System.out.println("Total parking fee to pay: " + charges);

        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.vacant();

        activeTickets.remove(ticket.getTicketNumber());

        return ticket.getVehicle();
    }
}
