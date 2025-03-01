package wildfarm;

public class Cat extends Feline {
    private final String breed;

    public Cat(String type, String name, Double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        int index = sb.indexOf(" ");
        sb.insert(index, String.format(" %s,", breed));

        return sb.toString();
    }
}
