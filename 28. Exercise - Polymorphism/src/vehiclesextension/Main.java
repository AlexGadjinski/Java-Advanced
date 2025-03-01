package vehiclesextension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split(" ");
        String[] truckInfo = scanner.nextLine().split(" ");
        String[] busInfo = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "Drive" -> {
                    switch (input[1]) {
                        case "Car" -> System.out.println(car.drive(Double.parseDouble(input[2])));
                        case "Truck" -> System.out.println(truck.drive(Double.parseDouble(input[2])));
                        case "Bus" -> System.out.println(bus.drive(Double.parseDouble(input[2])));
                    }
                }
                case "DriveEmpty" -> {
                    if ("Bus".equals(input[1])) {
                        System.out.println(bus.driveEmpty(Double.parseDouble(input[2])));
                    }
                }
                case "Refuel" -> {
                    switch (input[1]) {
                        case "Car" -> car.refuel(Double.parseDouble(input[2]));
                        case "Truck" -> truck.refuel(Double.parseDouble(input[2]));
                        case "Bus" -> bus.refuel(Double.parseDouble(input[2]));
                    }
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
