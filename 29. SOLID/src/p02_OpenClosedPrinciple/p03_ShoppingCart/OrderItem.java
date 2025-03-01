package p02_OpenClosedPrinciple.p03_ShoppingCart;

public class OrderItem {
//    private SKUS sku;
    private String sku;

    private int Quantity;

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
