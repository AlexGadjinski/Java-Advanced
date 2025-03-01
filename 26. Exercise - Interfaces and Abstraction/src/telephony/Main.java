package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).toList();
        List<String> urls = Arrays.stream(scanner.nextLine().split(" ")).toList();

        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
