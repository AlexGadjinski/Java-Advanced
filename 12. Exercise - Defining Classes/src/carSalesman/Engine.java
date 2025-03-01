package carSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    int getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}
