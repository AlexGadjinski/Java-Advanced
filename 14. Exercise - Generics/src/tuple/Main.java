package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        for (int i = 0; i < 3; i++) {
//            String[] input = scanner.nextLine().split(" ");
//            switch (i) {
//                case 0 -> {
//                    String name = input[0] + " " + input[1];
//                    String address = input[2];
//                    Tuple<String, String> tuple = new Tuple<>(name, address);
//                    System.out.println(tuple);
//                }
//                case 1 -> {
//                    String name = input[0];
//                    int litersOfBeer = Integer.parseInt(input[1]);
//                    Tuple<String, Integer> tuple = new Tuple<>(name, litersOfBeer);
//                    System.out.println(tuple);
//                }
//                case 2 -> {
//                    int num1 = Integer.parseInt(input[0]);
//                    double num2 = Double.parseDouble(input[1]);
//                    Tuple<Integer, Double> tuple = new Tuple<>(num1, num2);
//                    System.out.println(tuple);
//                }
//            }
//        }

        for (int i = 0; i < 3; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (i) {
                case 0 -> {
                    String name = input[0] + " " + input[1];
                    String address = input[2];
                    String town = input[3];
                    Threeuple<String, String, String> threeuple = new Threeuple<>(name, address, town);
                    System.out.println(threeuple);
                }
                case 1 -> {
                    String name = input[0];
                    int litersOfBeer = Integer.parseInt(input[1]);
                    boolean isDrunk = input[2].equals("drunk");
                    Threeuple<String, Integer, Boolean> threeuple = new Threeuple<>(name, litersOfBeer, isDrunk);
                    System.out.println(threeuple);
                }
                case 2 -> {
                    String personName = input[0];
                    double bankBalance = Double.parseDouble(input[1]);
                    String bankName = input[2];
                    Threeuple<String, Double, String> threeuple = new Threeuple<>(personName, bankBalance, bankName);
                    System.out.println(threeuple);
                }
            }
        }
    }
}
