package jedigalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long totalStars = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix);

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = readArray(command);
            int[] evilCoordinates = readArray(scanner.nextLine());

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];

            moveEvilPlayer(matrix, evilRow, evilCol);
            moveJediAndCollectStars(matrix, jediRow, jediCol);

            command = scanner.nextLine();
        }
        System.out.println(totalStars);
    }

    private static void moveJediAndCollectStars(int[][] matrix, int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < matrix[0].length) {
            if (jediRow < matrix.length && jediCol >= 0) {
                totalStars += matrix[jediRow][jediCol];
            }
            jediCol++;
            jediRow--;
        }
    }

    private static void moveEvilPlayer(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static int[] readArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fillMatrix(int[][] matrix) {
        int value = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = value++;
            }
        }
    }
}
