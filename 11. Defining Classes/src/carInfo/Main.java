package carInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            Car car;
            switch (data.length) {
                case 1 -> car = new Car(data[0]);
                case 2 -> car = new Car(data[0], data[1]);
                default -> car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            }

            System.out.println(car.carInfo());
        }
    }
}
