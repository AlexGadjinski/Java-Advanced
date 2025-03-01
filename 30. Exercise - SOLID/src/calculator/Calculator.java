package calculator;

import products.Product;

import java.util.List;

public abstract class Calculator {
    public abstract double sum(List<Product> products);
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
