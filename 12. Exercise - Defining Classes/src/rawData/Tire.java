package rawData;

public class Tire {
    private double pressure;
    private int age;

    Tire(double tirePressure, int tireAge) {
        this.pressure = tirePressure;
        this.age = tireAge;
    }

    boolean isWithLowPressure() {
        return pressure < 1;
    }
}
