import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                char symbol = matrix[r][c];
                if (symbol == 'q') {
                    if (!rowIsValid(matrix[r], c)) {
                        break;
                    }
                    if (!columnIsValid(matrix, r, c)) {
                        break;
                    }
                    if (!diagonalIsValid(matrix, r, c)) {
                        break;
                    }
                    System.out.println(r + " " + c);
                    return;
                }
            }
        }
    }

    public static boolean rowIsValid(char[] arr, int c) {
        for (int i = c + 1; i < 8; i++) {
            if (arr[i] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static boolean columnIsValid(char[][] matrix, int r, int c) {
        for (int i = 0; i < 8; i++) {
            if (i == r) {
                continue;
            }
            if (matrix[i][c] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static boolean diagonalIsValid(char[][] matrix, int r, int c) {
        int currentRow = r;
        int currentCol = c;

        while (currentRow > 0 && currentCol > 0) {
            if (matrix[currentRow - 1][currentCol - 1] == 'q') {
                return false;
            }
            currentRow--;
            currentCol--;
        }

        currentRow = r;
        currentCol = c;
        while (currentRow < 7 && currentCol > 0) {
            if (matrix[currentRow + 1][currentCol - 1] == 'q') {
                return false;
            }
            currentRow++;
            currentCol--;
        }

        currentRow = r;
        currentCol = c;
        while (currentRow > 0 && currentCol < 7) {
            if (matrix[currentRow - 1][currentCol + 1] == 'q') {
                return false;
            }
            currentRow--;
            currentCol++;
        }

        currentRow = r;
        currentCol = c;
        while (currentRow < 7 && currentCol < 7) {
            if (matrix[currentRow + 1][currentCol + 1] == 'q') {
                return false;
            }
            currentRow++;
            currentCol++;
        }
        return true;
    }
}
