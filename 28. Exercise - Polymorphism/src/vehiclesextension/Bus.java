package vehiclesextension;

public class Bus extends Vehicle {
    private final double emptyBusFuelCost;
    private final double nonEmptyBusFuelCost;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.emptyBusFuelCost = fuelConsumption;
        this.nonEmptyBusFuelCost = fuelConsumption + 1.4;
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumption(nonEmptyBusFuelCost);
        return super.drive(distance);
    }

    public String driveEmpty(double distance) {
        setFuelConsumption(emptyBusFuelCost);
        return super.drive(distance);
    }
}
