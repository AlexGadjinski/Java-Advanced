package carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            int power = Integer.parseInt(input[1]);
            int displacement = -1;
            String efficiency = "n/a";

            if (input.length == 4) {
                displacement = Integer.parseInt(input[2]);
                efficiency = input[3];
            } else if (input.length == 3) {
                if (Character.isLetter(input[2].charAt(0))) {
                    efficiency = input[2];
                } else {
                    displacement = Integer.parseInt(input[2]);
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            String engineModel = input[1];
            int weight = -1;
            String color = "n/a";

            if (input.length == 4) {
                weight = Integer.parseInt(input[2]);
                color = input[3];
            } else if (input.length == 3) {
                if (Character.isLetter(input[2].charAt(0))) {
                    color = input[2];
                } else {
                    weight = Integer.parseInt(input[2]);
                }
            }

            Engine engine = getEngine(engines, engineModel);
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static Engine getEngine(List<Engine> engines, String engineModel) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(engineModel)) {
                return engine;
            }
        }
        return null;
    }
}
