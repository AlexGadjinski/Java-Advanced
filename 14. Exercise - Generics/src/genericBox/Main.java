package genericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        1-ва задача

//        Box<String> stringBox = new Box<>();
//
//        for (int i = 0; i < n; i++) {
//            String text = scanner.nextLine();
//            stringBox.add(text);
//        }
//
//        System.out.println(stringBox);


//        2-ра задача
//        Box<Integer> integerBox = new Box<>();
//
//        for (int i = 0; i < n ; i++) {
//            int number = Integer.parseInt(scanner.nextLine());
//            integerBox.add(number);
//        }
//
//        System.out.println(integerBox);


//        3-та / 4-та задача
//        Box<String> stringBox = new Box<>();
//
//        for (int i = 0; i < n ; i++) {
//            String text = scanner.nextLine();
//            stringBox.add(text);
//        }
//
//        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        int firstIndex = input[0];
//        int secondIndex = input[1];
//
//        stringBox.swap(firstIndex, secondIndex);
//
//        System.out.println(stringBox);


        Box<Double> doubleBox = new Box<>();

        for (int i = 0; i < n ; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            doubleBox.add(num);
        }

        double valueToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(doubleBox.countGreaterValues(valueToCompare));
    }
}
