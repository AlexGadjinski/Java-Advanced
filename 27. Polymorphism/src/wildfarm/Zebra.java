package wildfarm;

public class Zebra extends Mammal {
    public Zebra(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Zebras are not eating that type of food!");
            return;
        }
        super.eat(food);
    }
}
