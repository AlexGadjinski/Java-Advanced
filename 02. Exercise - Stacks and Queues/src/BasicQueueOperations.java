import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numbersToAdd = input[0];
        int numbersToRemove = input[1];
        int numToFind = input[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numbersToAdd; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 0; i < numbersToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(numToFind)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
