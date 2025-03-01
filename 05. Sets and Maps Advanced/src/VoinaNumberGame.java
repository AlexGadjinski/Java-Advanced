import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = readSet(scanner);
        LinkedHashSet<Integer> secondPlayer = readSet(scanner);

        int rounds = 50;

        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int firstPlayerNum = getFirstNumber(firstPlayer);
            int secondPlayerNum = getFirstNumber(secondPlayer);

            firstPlayer.remove(firstPlayerNum);
            secondPlayer.remove(secondPlayerNum);

            if (firstPlayerNum > secondPlayerNum) {
                firstPlayer.add(firstPlayerNum);
                firstPlayer.add(secondPlayerNum);
            } else if (secondPlayerNum > firstPlayerNum) {
                secondPlayer.add(firstPlayerNum);
                secondPlayer.add(secondPlayerNum);
            } else {
                firstPlayer.add(firstPlayerNum);
                secondPlayer.add(secondPlayerNum);
            }
        }

        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }

    private static int getFirstNumber(LinkedHashSet<Integer> firstPlayer) {
        for (Integer number : firstPlayer) {
            return number;
        }
        return 0;
    }

    private static LinkedHashSet<Integer> readSet(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
