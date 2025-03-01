package cards1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Suits")) {
            System.out.println("Card Suits:");

            for (Suit suit : Suit.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit);
            }
        } else if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");

            for (Rank rank : Rank.values()) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank);
            }
        }
    }
}
