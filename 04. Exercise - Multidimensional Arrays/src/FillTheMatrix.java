import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = new int[size];
        }
        switch (pattern) {
            case "A" -> fillMatrixFirstPattern(matrix);
            case "B" -> fillMatrixSecondPattern(matrix);
        }

        for (int[] array : matrix) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixFirstPattern(int[][] matrix) {
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = num++;
            }
        }
    }

    public static void fillMatrixSecondPattern(int[][] matrix) {
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = num++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = num++;
                }
            }
        }
    }
}
