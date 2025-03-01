import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> initialFuel = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> neededFuel = new ArrayDeque<>(); //queue

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(initialFuel::push);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(consumptionIndex::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(neededFuel::offer);

        int reachedAltitudes = 0;

        while (!initialFuel.isEmpty()) {
            int totalFuel = initialFuel.pop() - consumptionIndex.poll();
            int fuelNeeded = neededFuel.poll();

            if (totalFuel >= fuelNeeded) {
                System.out.printf("John has reached: Altitude %d\n", ++reachedAltitudes);
            } else {
                System.out.printf("John did not reach: Altitude %d\n", reachedAltitudes + 1);
                System.out.print("John failed to reach the top.\n");
                if (reachedAltitudes > 0) {
                    System.out.print("Reached altitudes: Altitude 1");
                    for (int i = 2; i <= reachedAltitudes; i++) {
                        System.out.printf(", Altitude %d", i);
                    }
                } else {
                    System.out.println("John didn't reach any altitude.");
                }
                return;
            }
        }

        System.out.println("John has reached all the altitudes and managed to reach the top!");
    }
}
