package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split(" ");
        String[] truckInfo = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "Drive" -> {
                    switch (input[1]) {
                        case "Car" -> System.out.println(car.drive(Double.parseDouble(input[2])));
                        case "Truck" -> System.out.println(truck.drive(Double.parseDouble(input[2])));
                    }
                }
                case "Refuel" -> {
                    switch (input[1]) {
                        case "Car" -> car.refuel(Double.parseDouble(input[2]));
                        case "Truck" -> truck.refuel(Double.parseDouble(input[2]));
                    }
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
