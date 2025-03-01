package calculator;

import products.Product;
import products.drink.Drink;
import products.food.Food;

import java.util.List;

public class QuantityCalculator extends Calculator {
    @Override
    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            if (product instanceof Drink) {
                sum += ((Drink) product).getLiters();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }
        }
        return sum;
    }
}
