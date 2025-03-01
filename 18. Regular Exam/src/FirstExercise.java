import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packages = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> couriers = new ArrayDeque<>(); //queue

        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(packages::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(couriers::offer);

        int totalWeight = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()) {
            int packageWeight = packages.pop();
            int capacity = couriers.poll();

            if (capacity >= packageWeight) {
                if (capacity > packageWeight) {
                    capacity -= packageWeight * 2;
                    if (capacity > 0) {
                        couriers.offer(capacity);
                    }
                }
                totalWeight += packageWeight;
            } else {
                packageWeight -= capacity;
                totalWeight += capacity;
                packages.push(packageWeight);
            }
        }

        System.out.printf("Total weight: %d kg\n", totalWeight);
        if (packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packages.isEmpty()) {
            String remainingPackages = getPackages(packages);
            System.out.println("Unfortunately, there are no more available couriers to deliver the following packages: "
            + remainingPackages);
        } else {
            String remainingCouriers = couriers.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Couriers are still on duty: "
            + remainingCouriers + " but there are no more packages to deliver.");
        }
    }

    public static String getPackages(ArrayDeque<Integer> packages) {
        int[] arr = new int[packages.size()];

        int counter = packages.size() - 1;
        while (!packages.isEmpty()) {
            arr[counter--] = packages.pop();
        }

        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }
}
