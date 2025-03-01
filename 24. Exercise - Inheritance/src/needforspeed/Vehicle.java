package needforspeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        setFuel(fuel);
        setHorsePower(horsePower);
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void drive(double kilometres) {
        double fuelNeeded = kilometres * fuelConsumption;
        if (fuelNeeded <= fuel) {
            fuel -= fuelNeeded;
        }
    }
}
