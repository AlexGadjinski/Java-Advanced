import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDimNum = Integer.parseInt(scanner.nextLine());
        int secondDimNum = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, firstDimNum, secondDimNum);
        char[][] secondMatrix = readMatrix(scanner, firstDimNum, secondDimNum);

        char[][] resultMatrix = new char[firstDimNum][secondDimNum];

        for (int i = 0; i < firstDimNum; i++) {
            for (int j = 0; j < secondDimNum; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    resultMatrix[i][j] = firstMatrix[i][j];
                } else {
                    resultMatrix[i][j] = '*';
                }
            }
        }

        for (char[] array : resultMatrix) {
            for (char c : array) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static char[][] readMatrix(Scanner scanner, int firstDimNum, int secondDimNum) {
        char[][] matrix = new char[firstDimNum][secondDimNum];
        for (int i = 0; i < firstDimNum; i++) {
            matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        return matrix;
    }
}
