package vehiclesextension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }
}
