package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {
            String animalType = input;
            String[] tokens = scanner.nextLine().split(" ");

            String name = "";
            int age = -1;
            String gender = "";
            for (int i = 0; i < tokens.length; i++) {
                switch (i) {
                    case 0 -> name = tokens[0];
                    case 1 -> age = Integer.parseInt(tokens[1]);
                    case 2 -> gender = tokens[2];
                }
            }

            try {
                Animal animal = createAnimal(animalType, name, age, gender);
                System.out.println(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }

    public static Animal createAnimal(String animalType, String name, int age, String gender) {
        return switch (animalType) {
            case "Dog" -> new Dog(name, age, gender);
            case "Cat" -> new Cat(name, age, gender);
            case "Frog" -> new Frog(name, age, gender);
            case "Kitten" -> new Kitten(name, age);
            default -> new Tomcat(name, age);
        };
    }
}
