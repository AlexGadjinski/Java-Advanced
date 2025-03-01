import java.util.Scanner;

public class SecondExercise {
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        findStartCoordinates(matrix);

        int energy = 15;
        int nectar = 0;
        boolean alreadyRestored = false;

        while (true) {
            if (energy <= 0) {
                if (nectar < 30 || alreadyRestored) {
                    System.out.println("This is the end! Beesy ran out of energy.");
                    printMatrix(matrix);
                    return;
                } else {
                    energy += nectar - 30;
                    alreadyRestored = true;
                }
            }

            move(matrix, scanner.nextLine());
            energy--;

            if (matrix[row][col] == 'H') {
                break;
            } else if (matrix[row][col] != '-') {
                int nectarValue = Integer.parseInt(matrix[row][col] + "");
                nectar += nectarValue;
            }
        }

        if (nectar >= 30) {
            System.out.println("Great job, Beesy! The hive is full. Energy left: " + energy);
        } else {
            System.out.println("Beesy did not manage to collect enough nectar.");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        matrix[row][col] = 'B';
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void move(char[][] matrix, String direction) {
        matrix[row][col] = '-';
        switch (direction) {
            case "up" -> row--;
            case "down" -> row++;
            case "left" -> col--;
            case "right" -> col++;
        }
        fixBoundaries(matrix.length);
    }

    public static void fixBoundaries(int size) {
        if (row == -1) {
            row += size;
        } else if (row == size) {
            row -= size;
        } else if (col == -1) {
            col += size;
        } else if (col == size) {
            col -= size;
        }
    }

    public static void findStartCoordinates(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }
}
