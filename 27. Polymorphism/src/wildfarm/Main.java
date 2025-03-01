package wildfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String[] foodInfo = scanner.nextLine().split(" ");

            Animal animal = getAnimal(tokens);
            Food food = getFood(foodInfo);

            animal.makeSound();
            animal.eat(food);
            animalList.add(animal);

            input = scanner.nextLine();
        }
        animalList.forEach(System.out::println);
    }

    private static Animal getAnimal(String[] tokens) {
        return switch (tokens.length) {
            case 5 -> new Cat(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            case 4 -> switch (tokens[0]) {
                case "Mouse" -> new Mouse(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                case "Tiger" -> new Tiger(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                case "Zebra" -> new Zebra(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                default -> throw new IllegalArgumentException("Unsupported animal type");
            };
            default -> throw new IllegalArgumentException("Unsupported animal type");
        };
    }
    private static Food getFood(String[] foodInfo) {
        return switch (foodInfo[0]) {
            case "Vegetable" -> new Vegetable(Integer.parseInt(foodInfo[1]));
            case "Meat" -> new Meat(Integer.parseInt(foodInfo[1]));
            default -> throw new IllegalArgumentException("Unsupported food type");
        };
    }
}
