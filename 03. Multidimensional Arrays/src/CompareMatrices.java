import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        String result = compareMatrices(firstMatrix, secondMatrix)
                ? "equal"
                : "not equal";
        System.out.println(result);

    }

    public static int[][] readMatrix(Scanner scanner) {
        int[] input = readArray(scanner);
        int firstDimNum = input[0];
        int secondDimNum = input[1];

        int[][] matrix = new int[firstDimNum][secondDimNum];

        for (int i = 0; i < firstDimNum; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
