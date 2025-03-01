import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readIntArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readStringArray(scanner);
        }

        while (true) {
            String[] command = readStringArray(scanner);
            if (command[0].equals("END")) {
                break;
            }

            if (!isValid(command, rows, cols)) {
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);

            String elem1 = matrix[row1][col1];
            String elem2 = matrix[row2][col2];

            matrix[row1][col1] = elem2;
            matrix[row2][col2] = elem1;
            printMatrix(matrix);
        }
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] readStringArray(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }

    private static boolean isValid(String[] command, int rows, int cols) {
        if (command.length != 5 || !command[0].equals("swap")) {
            return false;
        }
        for (int i = 1; i < command.length; i++) {
            int coordinate = Integer.parseInt(command[i]);
            if (i % 2 != 0) {
                if (coordinate > rows - 1 || coordinate < 0) {
                    return false;
                }
            } else {
                if (coordinate > cols - 1 || coordinate < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String el : array) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
