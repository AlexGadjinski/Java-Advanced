package pizzacalories;

import pizzacalories.Dough;
import pizzacalories.Pizza;
import pizzacalories.Topping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza = createPizza(scanner.nextLine());
        Dough dough = createDough(scanner.nextLine());
        pizza.setDough(dough);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            Topping topping = createTopping(input);
            pizza.addTopping(topping);

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }

    private static Topping createTopping(String input) {
        String toppingType = input.split(" ")[1];
        double weight = Double.parseDouble(input.split(" ")[2]);
        return new Topping(toppingType, weight);
    }

    private static Dough createDough(String input) {
        String flourType = input.split(" ")[1];
        String bakingTechnique = input.split(" ")[2];
        double weight = Double.parseDouble(input.split(" ")[3]);
        return new Dough(flourType, bakingTechnique, weight);
    }

    private static Pizza createPizza(String input) {
        String pizzaName = input.split(" ")[1];
        int numberOfToppings = Integer.parseInt(input.split(" ")[2]);

        return new Pizza(pizzaName, numberOfToppings);
    }
}
