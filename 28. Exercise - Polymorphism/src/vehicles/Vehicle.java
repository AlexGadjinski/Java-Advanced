package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private final double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void reduceFuel(double fuelQuantity) {
        this.fuelQuantity -= fuelQuantity;
    }

    protected void increaseFuel(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded <= getFuelQuantity()) {
            reduceFuel(fuelNeeded);
            return String.format("%s travelled %s km",
                    getClass().getSimpleName(), new DecimalFormat("0.##").format(distance));
        }
        return "%s needs refueling".formatted(getClass().getSimpleName());
    }
    public abstract void refuel(double liters);

    @Override
    public String toString() {
        return "%s: %.2f".formatted(getClass().getSimpleName(), fuelQuantity);
    }
}
