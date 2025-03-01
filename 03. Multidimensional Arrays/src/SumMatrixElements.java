import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);

        int firstDimNum = input[0];
        int secondDimNum = input[1];
        int sumOfElements = 0;

        int[][] matrix = new int[firstDimNum][];

        for (int i = 0; i < firstDimNum; i++) {
            matrix[i] = readArray(scanner);
        }
        for (int[] array : matrix) {
            for (int num : array) {
                sumOfElements += num;
            }
        }

        System.out.printf("%d\n%d\n%d", firstDimNum, secondDimNum, sumOfElements);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
