import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {
            matrix[i] = readArray(scanner);
        }

        int[] input = readArray(scanner);
        int wrongValue = matrix[input[0]][input[1]];

        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = matrix[i].clone();
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int newElement = correctElement(matrix, r, c);
                    result[r][c] = newElement;
                }
            }
        }

        for (int[] arr : result) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int correctElement(int[][] matrix, int r, int c) {
        int wrongValue = matrix[r][c];
        int sum = 0;
        if (c > 0) {
            int elementToAdd = matrix[r][c - 1];
            if (elementToAdd != wrongValue) {
                sum += elementToAdd;
            }
        }
        if (r > 0) {
            int elementToAdd = matrix[r - 1][c];
            if (elementToAdd != wrongValue) {
                sum += elementToAdd;
            }
        }
        if (c < matrix[r].length - 1) {
            int elementToAdd = matrix[r][c + 1];
            if (elementToAdd != wrongValue) {
                sum += matrix[r][c + 1];
            }
        }
        if (r < matrix.length - 1 && matrix[r + 1].length == matrix[r].length) {
            int elementToAdd = matrix[r + 1][c];
            if (elementToAdd != wrongValue) {
                sum += matrix[r + 1][c];
            }
        }
        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
