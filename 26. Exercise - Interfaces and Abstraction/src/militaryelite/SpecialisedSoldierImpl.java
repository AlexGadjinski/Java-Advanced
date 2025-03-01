package militaryelite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    private void setCorps(String corps) {
        switch (corps) {
            case "Airforces" -> this.corps = Corps.AIR_FORCES;
            case "Marines" -> this.corps = Corps.MARINES;
            default -> throw new IllegalArgumentException();
        }
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return "%s\nCorps: %s".formatted(super.toString(), corps);
    }
}
