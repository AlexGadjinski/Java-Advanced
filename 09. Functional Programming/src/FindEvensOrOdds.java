import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = input[0];
        int upperBound = input[1];

        String condition = scanner.nextLine();

        IntPredicate predicate = condition.equals("even")
                ? n -> n % 2 == 0
                : n -> n % 2 != 0;

        IntStream.rangeClosed(lowerBound, upperBound)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
