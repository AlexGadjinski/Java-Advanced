package rawData;

public class Engine {
    private int speed;
    private int power;

    Engine(int engineSpeed, int enginePower) {
        this.speed = engineSpeed;
        this.power = enginePower;
    }

    int getPower() {
        return power;
    }
}
