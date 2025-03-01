import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList();

        Comparator<Integer> comparator = (firstNum, secondNum) -> {
            if (firstNum % 2 != 0 && secondNum % 2 == 0) {
                return 1;
            } else if (firstNum % 2 == 0 && secondNum % 2 != 0) {
                return -1;
            }
            return firstNum.compareTo(secondNum);
        };

        numbers.stream()
                .sorted(comparator)
                .forEach(n -> System.out.print(n + " "));
    }
}
