package p02_OpenClosedPrinciple.p03_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderItem> items;

    public String custmerEmail;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Iterable<OrderItem> getItems() {
        return new ArrayList<OrderItem>(this.items);
    }


    public String getCustmerEmail() {
        return this.custmerEmail;
    }

    public void setCustmerEmail(String custmerEmail) {
        this.custmerEmail = custmerEmail;
    }

    public void add(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public double getTotalAmount() {
//        return items.stream()
//                .map(SKUS::getPrice)
//                .sum;
        return 0;
    }
}
