import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split(" ");

        Predicate<String> validLength =
                name -> name.length() <= n;

        Arrays.stream(names)
                .filter(validLength)
                .forEach(System.out::println);
    }
}
