import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rotation = Integer.parseInt(input.replace("Rotate(", "").replace(")", ""));
        int rotationTimes = rotation / 90;

        List<String> words = new ArrayList<>();

        input = scanner.nextLine();
        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }
        int rows = words.size();
        int cols = Collections.max(words, Comparator.comparing(String::length)).length();

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, words);

        for (int i = 0; i < rotationTimes; i++) {
            matrix = rotate90(matrix);
        }

        printMatrix(matrix);
    }

    private static char[][] rotate90(char[][] oldMatrix) {
        int newRows = oldMatrix[0].length;
        int newCols = oldMatrix.length;
        char[][] newMatrix = new char[newRows][newCols];

        for (int c = 0; c < oldMatrix[0].length; c++) {
            int counter = 0;
            for (int r = oldMatrix.length - 1; r >= 0; r--) {
                char symbol = oldMatrix[r][c];
                newMatrix[c][counter] = symbol;
                counter++;
            }
        }
        return newMatrix;
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (int r = 0; r < matrix.length; r++) {
            String word = words.get(r);
            for (int c = 0; c < matrix[r].length; c++) {
                if (c <= word.length() - 1) {
                    matrix[r][c] = word.charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char c : array) {
                System.out.print(c + "");
            }
            System.out.println();
        }
    }
}
