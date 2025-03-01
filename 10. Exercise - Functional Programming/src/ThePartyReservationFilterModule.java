import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> reservations = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Print")) {
                break;
            }

            Predicate<String> predicate = getPredicate(input.split(";"));
            String condition = input.substring(input.indexOf(";") + 1);

            if (input.split(";")[0].equals("Add filter")) {
                predicates.putIfAbsent(condition, predicate);
            } else if (input.split(";")[0].equals("Remove filter")) {
                predicates.remove(condition);
            }
        }

        reservations.removeIf(r -> {
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(r)) {
                    return true;
                }
            }
            return false;
        });
        reservations.forEach(r -> System.out.print(r + " "));
    }

    private static Predicate<String> getPredicate(String[] command) {
        return switch (command[1]) {
            case "Starts with" -> name -> name.startsWith(command[2]);
            case "Ends with" -> name -> name.endsWith(command[2]);
            case "Length" -> name -> name.length() == Integer.parseInt(command[2]);
            case "Contains" -> name -> name.contains(command[2]);
            default -> throw new IllegalArgumentException("Unsupported Operation");
        };
    }
}
