package wildfarm;

public class Tiger extends Feline {
    public Tiger(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            System.out.println("Tigers are not eating that type of food!");
            return;
        }
        super.eat(food);
    }
}
