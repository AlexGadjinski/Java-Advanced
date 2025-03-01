import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);

        int rows = input[0];
        int cols = input[1];
        
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];

        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {
                int current = matrix[r][c];
                int right = matrix[r][c + 1];
                int bottom = matrix[r + 1][c];
                int bottomRight = matrix[r + 1][c + 1];

                int sum = current + right + bottom + bottomRight;
                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix[0][0] = current;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = bottom;
                    maxMatrix[1][1] = bottomRight;
                }
            }
        }

        System.out.printf("%d %d\n%d %d\n%d", maxMatrix[0][0], maxMatrix[0][1], maxMatrix[1][0], maxMatrix[1][1], maxSum);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
