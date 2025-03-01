package wildfarm;

public class Mouse extends Mammal {
    public Mouse(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Mice are not eating that type of food!");
            return;
        }
        super.eat(food);
    }
}
