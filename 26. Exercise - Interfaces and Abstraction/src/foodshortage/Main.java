package foodshortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Buyer buyer = getBuyer(tokens);
            buyers.add(buyer);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String name = input;
            buyers.stream()
                    .filter(b -> b.getName().equals(name))
                    .forEach(Buyer::buyFood);

            input = scanner.nextLine();
        }

        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }

    private static Buyer getBuyer(String[] tokens) {
        return switch (tokens.length) {
            case 4 -> new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            case 3 -> new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            default -> throw new IllegalArgumentException("Invalid input provided");
        };
    }
}
