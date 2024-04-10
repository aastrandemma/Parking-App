package org.github.aastrandemma.model;

public enum VehicleType {
    OTHER(0, "Other"),
    CAR(1, "Car"),
    MOTORCYCLE(2, "Motorcycle"),
    TRUCK(3, "Truck"),
    VAN(4, "Van"),
    EL(5, "Electric Vehicle");

    private final int code;
    private final String name;

    VehicleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}