import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toList();
        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + numbers.stream().mapToInt(e -> e).sum());

//        String input = scanner.nextLine();
//
//        Function<String, Integer> getCount =
//                s -> s.split(", ").length;
//        Function<String, Integer> getSum =
//                s -> Arrays.stream(s.split(", "))
//                        .mapToInt(Integer::parseInt)
//                        .sum();
//
//        System.out.printf("Count = %d\n", getCount.apply(input));
//        System.out.printf("Sum = %d\n", getSum.apply(input));
    }
}
