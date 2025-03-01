import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        printDiagonals(matrix, rows - 1, cols - 1);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void printDiagonals(int[][] matrix, int startRow, int startCol) {

        while (startCol >= 0) {

            int r = startRow;
            for (int c = startCol; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
                if (--r < 0) {
                    break;
                }
            }
            startCol--;
            System.out.println();
        }

        if (startRow == 0) {
            return;
        }

        while (--startRow != 0) {

            int r = startRow;
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
                if (--r < 0) {
                    break;
                }
            }
            System.out.println();
        }
        System.out.println(matrix[startRow][0]);
    }
}
