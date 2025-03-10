import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .filter(i -> i % 2 == 0)
                        .toList();

        System.out.println(convertToString(numbers));
        System.out.println(convertToString(numbers.stream()
                .sorted()
                .toList()));
    }

    public static String convertToString(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
