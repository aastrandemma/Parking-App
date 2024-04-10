package org.github.aastrandemma.model;

import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private Customer customer;
    private ParkingSpot parkingSpot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Vehicle associatedVehicle;

    public Reservation(Customer customer, ParkingSpot parkingSpot, int hours, Vehicle associatedVehicle) {
        this.customer = customer;
        this.parkingSpot = parkingSpot;
        this.startTime = LocalDateTime.now();
        setEndTime(hours);
        this.associatedVehicle = associatedVehicle;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    public void setEndTime(int hours) {
        if (hours <= 0) throw new IllegalArgumentException("Hours should be a positive number.");
        this.endTime = startTime.plusHours(hours);
    }

    public void reserve() {
        if (customer.getReservation() != null) throw new IllegalArgumentException("Customer has already a reserved parking spot.");
        if (parkingSpot == null) throw new IllegalArgumentException("Parking spot should not be null.");
        if (parkingSpot.isOccupied()) throw new IllegalArgumentException("Parking spot is already occupied!");
        parkingSpot.occupy();
        customer.setReservation(this);
    }

    public void cancel() {
        parkingSpot.vacate();
        customer.setReservation(null);
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation Id: ").append(id);
        if (customer == null) {
            sb.append(", Customer: ").append(" - ");
        } else {
            sb.append(", Customer: ").append(customer.getDescription());
        }
        sb.append(", Parking Spot: ").append(parkingSpot.getSpotNumber())
                .append(", Start Time: ").append(startTime)
                .append(", End Time: ").append(endTime)
                .append(", Associated Vehicle: ").append(associatedVehicle.getLicensePlate());
        return sb.toString();
    }
}