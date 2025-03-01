package wildfarm;

public abstract class Mammal extends Animal {
    private final String livingRegion;

    protected Mammal(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        String[] data = super.toString().split(" ");
        return String.format("%s[%s, %s, %s, %s]", data[0], data[1], data[2], livingRegion, data[3]);
    }
}
