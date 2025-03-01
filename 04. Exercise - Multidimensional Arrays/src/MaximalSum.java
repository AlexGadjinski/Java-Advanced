import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int maxMatrixRow = 0;
        int maxMatrixCol = 0;

        for (int r = 0; r + 2 < matrix.length; r++) {
            for (int c = 0; c + 2 < matrix[r].length; c++) {
                int currentSum =
                                matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
                                matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2] +
                                matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxMatrixRow = r;
                    maxMatrixCol = c;
                }
            }
        }
        System.out.printf("Sum = %d\n", maxSum);
        printMatrix(matrix, maxMatrixRow, maxMatrixCol);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
