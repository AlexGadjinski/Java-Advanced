package catLady;

public class StreetExtraordinaire extends Cat{
    private double decibelsOfMeows;

    StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getClass().getSimpleName(), name, decibelsOfMeows);
    }
}
