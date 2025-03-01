package shoppingspree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > money) {
            String message = "%s can't afford %s".formatted(name, product.getName());
            throw new IllegalArgumentException(message);
        }
        money -= product.getCost();
        products.add(product);
    }

    @Override
    public String toString() {
        return products.isEmpty()
                ? name + " - Nothing bought"
                : name + " - " + products.stream().map(Product::getName).collect(Collectors.joining(", "));
    }
}
