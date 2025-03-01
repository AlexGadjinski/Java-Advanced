package speedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            cars.add(car);
        }

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("End")) {
                break;
            }

            String model = input[1];
            int kilometres = Integer.parseInt(input[2]);

            for (Car car : cars) {
                if (car.getModel().equals(model)) {
                    car.drive(kilometres);
                    break;
                }
            }
        }

        cars.forEach(System.out::println);
    }
}
