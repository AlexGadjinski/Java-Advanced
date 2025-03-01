package customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> stringCustomList = new CustomList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]) {
                case "Add" -> stringCustomList.add(input[1]);
                case "Remove" -> stringCustomList.remove(Integer.parseInt(input[1]));
                case "Contains" -> System.out.println(stringCustomList.contains(input[1]));
                case "Swap" -> stringCustomList.swap(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                case "Greater" -> System.out.println(stringCustomList.countGreaterThan(input[1]));
                case "Max" -> System.out.println(stringCustomList.getMax());
                case "Min" -> System.out.println(stringCustomList.getMin());
                case "Print" -> System.out.println(stringCustomList);
                case "Sort" -> stringCustomList.sort();
            }
        }
    }
}
