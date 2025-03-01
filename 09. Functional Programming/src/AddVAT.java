import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        DoubleUnaryOperator addVat = v -> v * 1.2;
//      работи с примитивни типове данни

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVat)
                .forEach(v -> System.out.printf("%.2f\n", v));


//      Function<Double, Double> addVatFunction = v -> v * 1.2;
//      работи с wrapper типове

//        Arrays.stream(scanner.nextLine().split(", "))
//                .map(Double::parseDouble)
//                .map(addVatFunction)
//                .forEach(v -> System.out.printf("%.2f\n", v));
    }
}
