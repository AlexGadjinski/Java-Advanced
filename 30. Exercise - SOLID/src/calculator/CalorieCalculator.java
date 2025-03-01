package calculator;

import products.Product;
import java.util.List;

public class CalorieCalculator extends Calculator {
    @Override
    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }
}
