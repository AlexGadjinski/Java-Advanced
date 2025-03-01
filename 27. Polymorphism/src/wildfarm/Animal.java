package wildfarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private final String name;
    private final String type;
    private final Double weight;
    private Integer foodEaten;

    protected Animal(String type, String name, Double weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", type, name, new DecimalFormat("0.##").format(weight), foodEaten);
    }
}
