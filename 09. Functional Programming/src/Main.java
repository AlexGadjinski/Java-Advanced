import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));

        Function<List<Integer>, Integer> getDoubleSum =
                l -> l.stream()
                        .mapToInt(e -> e * 2)
                        .sum();

        System.out.println(getDoubleSum.apply(numbers));


        Consumer<String> print =
                e -> System.out.println("Hello " + e);

        print.accept("World");


        Supplier<Integer> getRandomInt =
                () -> new Random().nextInt(51);

        System.out.println(getRandomInt.get());


        Predicate<Integer> isEven =
                n -> n % 2 == 0;

        System.out.println(isEven.test(3));
    }
}
