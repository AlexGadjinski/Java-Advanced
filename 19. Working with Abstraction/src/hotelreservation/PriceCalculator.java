package hotelreservation;

public class PriceCalculator {
    private final double pricePerDay;
    private final int days;
    private final Season season;
    private final DiscountType discountType;

    public PriceCalculator(double pricePerDay, int days, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = Season.valueOf(season.toUpperCase());
        this.discountType = DiscountType.fromString(discountType);
    }

    public double getTotalPrice() {
        return pricePerDay * days * season.getPriceMultiplier() * discountType.getDiscountMultiplier();
    }
}
