package catLady;

public class Siamese extends Cat {
    private double earSize;

    Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getClass().getSimpleName(), name, earSize);
    }
}
