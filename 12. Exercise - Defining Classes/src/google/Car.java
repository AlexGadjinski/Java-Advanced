package google;

public class Car {
    private String model;
    private int speed;

    Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String toString() {
        return model + " " + speed;
    }
}
