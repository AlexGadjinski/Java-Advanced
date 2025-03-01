import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numbersToAdd = input[0];
        int numbersToRemove = input[1];
        int numToFind = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersToAdd; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 0; i < numbersToRemove; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(numToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
