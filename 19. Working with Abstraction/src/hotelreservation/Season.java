package hotelreservation;

public enum Season {
    SPRING(2),
    SUMMER(4),
    AUTUMN(1),
    WINTER(3);

    private final int priceMultiplier;

    Season(int priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public int getPriceMultiplier() {
        return priceMultiplier;
    }
}
