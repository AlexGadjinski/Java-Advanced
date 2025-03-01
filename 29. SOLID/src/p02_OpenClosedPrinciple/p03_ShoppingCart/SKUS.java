package p02_OpenClosedPrinciple.p03_ShoppingCart;

public enum SKUS {
    ORANGES(4),
    STRAWBERRIES(3),
    PAIR(13);

    double price;

    SKUS(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
