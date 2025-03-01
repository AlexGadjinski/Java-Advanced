package speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        distance = 0;
    }

    String getModel() {
        return model;
    }

    void drive(int kilometres) {
        double neededFuel = fuelCost * kilometres;

        if (fuelAmount >= neededFuel) {
            fuelAmount -= neededFuel;
            distance += kilometres;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distance);
    }
}
