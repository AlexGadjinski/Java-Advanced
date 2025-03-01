package carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String displacement = engine.getDisplacement() == -1
                ? "n/a"
                : engine.getDisplacement() + "";
        String weightForPrint = weight == -1
                ? "n/a"
                : weight + "";
      return String.format("%s:\n" +
              "%s:\n" +
              "Power: %d\n" +
              "Displacement: %s\n" +
              "Efficiency: %s\n" +
              "Weight: %s\n" +
              "Color: %s",
              model, engine.getModel(), engine.getPower(), displacement, engine.getEfficiency(), weightForPrint, color);
    }
}
