package catLady;

public class Cymric extends Cat{
    private double furLength;

    Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getClass().getSimpleName(), name, furLength);
    }
}
