import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Predicate<String> startsWithUppercase =
                s -> Character.isUpperCase(s.charAt(0));

        Consumer<String> printer =
                System.out::println;


        List<String> words = Arrays.stream(text.split(" "))
                .filter(startsWithUppercase)
                .toList();

        System.out.println(words.size());
        words.forEach(printer);
    }
}
