package shoppingspree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for (String personInfo : scanner.nextLine().split(";")) {
            String name = personInfo.split("=")[0];
            double money = Double.parseDouble(personInfo.split("=")[1]);
            people.add(new Person(name, money));
        }

        for (String productInfo : scanner.nextLine().split(";")) {
            String name = productInfo.split("=")[0];
            double cost = Double.parseDouble(productInfo.split("=")[1]);
            products.add(new Product(name, cost));
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];

            Person person = people.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
            Product product = products.stream().filter(p -> p.getName().equals(productName)).findFirst().get();

            person.buyProduct(product);
            System.out.println(personName + " bought " + productName);

            command = scanner.nextLine();
        }
        people.forEach(System.out::println);
    }
}
