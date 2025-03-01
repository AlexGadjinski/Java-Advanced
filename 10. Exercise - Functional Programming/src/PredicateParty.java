import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("Party!")) {
                break;
            }

            Predicate<String> predicate = getPredicate(command);

            if (command[0].equals("Remove")) {
                people.removeIf(predicate);
            } else if (command[0].equals("Double")) {
                List<String> toAdd = new ArrayList<>();
                for (String person : people) {
                    if (predicate.test(person)) {
                        toAdd.add(person);
                    }
                }
                people.addAll(toAdd);
            }
        }

        String result = people.isEmpty()
                ? "Nobody is going to the party!"
                : people.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!";
        System.out.println(result);
    }

    private static Predicate<String> getPredicate(String[] command) {
        return switch (command[1]) {
            case "StartsWith" -> name -> name.startsWith(command[2]);
            case "EndsWith" -> name -> name.endsWith(command[2]);
            case "Length" -> name -> name.length() == Integer.parseInt(command[2]);
            default -> throw new IllegalArgumentException("Unsupported Operation");
        };
    }
}
