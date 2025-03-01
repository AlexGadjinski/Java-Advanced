import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        for (int i = numbers.length - 1; i >= numbers.length - 3 && i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
