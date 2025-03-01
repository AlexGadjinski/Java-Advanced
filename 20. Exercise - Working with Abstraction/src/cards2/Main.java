package cards2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rank rank = Rank.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        Card card = new Card(suit, rank);

        System.out.println(card);
    }
}
