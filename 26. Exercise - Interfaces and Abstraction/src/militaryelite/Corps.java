package militaryelite;

public enum Corps {
    AIR_FORCES,
    MARINES;

    @Override
    public String toString() {
        return switch (this) {
            case AIR_FORCES -> "Airforces";
            case MARINES -> "Marines";
        };
    }
}
