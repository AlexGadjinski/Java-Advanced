import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                return;
            } else if (input.equals("print")) {
                numbers.forEach(n -> System.out.print(n + " "));
                System.out.println();
            } else {
                numbers = getFunction(input).apply(numbers);
            }
        }
    }

    public static Function<List<Integer>, List<Integer>> getFunction(String command) {
        return switch (command) {
            case "add" -> l -> l.stream().map(n -> n + 1).collect(Collectors.toList());
            case "multiply" -> l -> l.stream().map(n -> n * 2).collect(Collectors.toList());
            case "subtract" -> l -> l.stream().map(n -> n - 1).collect(Collectors.toList());
            default -> throw new IllegalArgumentException("Unsupported command");
        };
    }
}
