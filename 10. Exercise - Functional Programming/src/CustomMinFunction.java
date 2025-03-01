import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        Function<HashSet<Integer>, Integer> findMinNum =
                h -> h.stream()
                        .mapToInt(n -> n)
                        .min()
                        .getAsInt();

        System.out.println(findMinNum.apply(numbers));
    }
}
