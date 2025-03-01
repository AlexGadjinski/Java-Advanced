import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            queue.offer(input[i]);
        }

        int day = 0;

        while (true) {
            ArrayDeque<Integer> newQueue = new ArrayDeque<>();
            int lastQueueSize = queue.size();
            for (int i = 0; i < lastQueueSize - 1; i++) {
                int num1 = queue.poll();
                int num2 = queue.peek();

                if (num1 <= num2) {
                    newQueue.offer(num1);
                }
            }
            newQueue.offer(queue.poll());
            if (lastQueueSize == newQueue.size()) {
                System.out.println(day);
                return;
            }
            day++;
            queue = new ArrayDeque<>(newQueue);
        }
    }
}
