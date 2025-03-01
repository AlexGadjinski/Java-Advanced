import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstSetSize = input[0];
        int secondSetSize = input[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            firstSet.add(n);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            secondSet.add(n);
        }

        for (Integer currentNum : firstSet) {
            if (secondSet.contains(currentNum)) {
                System.out.print(currentNum + " ");
            }
        }
    }
}
