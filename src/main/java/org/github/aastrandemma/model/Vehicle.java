package org.github.aastrandemma.model;

public class Vehicle {
    private String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        setLicensePlate(licensePlate);
        this.type = type;
    }

    public Vehicle(String licensePlate) {
        this(licensePlate, VehicleType.CAR);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null) throw new IllegalArgumentException("License Plate should not be null.");
        this.licensePlate = licensePlate;
    }

    public String getDescription() {
        return "This is a " + type + " with license plate " + licensePlate;
    }
}