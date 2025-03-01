import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = readArray(scanner);
        }

        int difference = 0;
        for (int i = 0; i < size; i++) {
            difference += matrix[i][i];
        }
        int col = size - 1;
        for (int i = 0; i < size; i++) {
            difference -= matrix[i][col];
            col--;
        }

        System.out.println(Math.abs(difference));
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
