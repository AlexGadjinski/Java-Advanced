import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String element = getPalindrome(i, j);
                matrix[i][j] = element;
            }
        }
        printMatrix(matrix);
    }

    public static String getPalindrome(int row, int col) {
        char firstLastLetter = (char)('a' + row);
        char midLetter = (char)(firstLastLetter + col);

        return String.format("%c%c%c", firstLastLetter, midLetter, firstLastLetter);
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
