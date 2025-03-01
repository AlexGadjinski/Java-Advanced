import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> peopleCards = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(": ");
            if (input[0].equals("JOKER")) {
                break;
            }

            String name = input[0];
            String[] cardsInput = input[1].split(", ");

            peopleCards.putIfAbsent(name, new HashSet<>());
            peopleCards.get(name).addAll(List.of(cardsInput));
        }

        for (var entry : peopleCards.entrySet()) {
            int sumOfCardsValues = 0;

            for (String card : entry.getValue()) {
                int power = switch (card.charAt(0)) {
                    case 'J' -> 11;
                    case 'Q' -> 12;
                    case 'K' -> 13;
                    case 'A' -> 14;
                    case '1' -> 10;
                    default -> Integer.parseInt(card.charAt(0) + "");
                };
                int type = switch (card.charAt(card.length() - 1)) {
                    case 'S' -> 4;
                    case 'H' -> 3;
                    case 'D' -> 2;
                    case 'C' -> 1;
                    default -> -1;
                };
                sumOfCardsValues += power * type;
            }
            System.out.printf("%s: %d\n", entry.getKey(), sumOfCardsValues);
        }
    }
}
