package vehiclesextension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private final double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void reduceFuel(double fuelQuantity) {
        this.fuelQuantity -= fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
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

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (liters + fuelQuantity > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            fuelQuantity += liters;
        }
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(getClass().getSimpleName(), fuelQuantity);
    }
}
