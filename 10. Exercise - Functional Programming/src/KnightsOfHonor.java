import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .toList();

        Consumer<String> printWithPrefix = s -> System.out.println("Sir " + s);

        names.forEach(printWithPrefix);
    }
}
