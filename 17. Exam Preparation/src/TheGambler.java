import java.util.Scanner;

public class TheGambler {
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int money = 100;

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        findStartCoordinates(matrix);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            move(matrix, input);
            if (!isInBoundaries(matrix, size)) {
                System.out.println("Game over! You lost everything!");
                return;
            }

            switch (matrix[row][col]) {
                case 'W' -> money += 100;
                case 'P' -> money -= 200;
                case 'J' -> {
                    money += 100000;
                    System.out.printf("You win the Jackpot!\nEnd of the game. Total amount: %d$\n", money);
                    printMatrix(matrix);
                    return;
                }
            }

            if (money <= 0) {
                System.out.println("Game over! You lost everything!");
                return;
            }
        }
        System.out.println("End of the game. Total amount: " + money + "$");
        printMatrix(matrix);
    }

    private static void move(char[][] matrix, String direction) {
        matrix[row][col] = '-';
        switch (direction) {
            case "up" -> row--;
            case "down" -> row++;
            case "left" -> col--;
            case "right" -> col++;
        }
    }

    private static boolean isInBoundaries(char[][] matrix, int size) {
        return row < size && row >= 0 && col < size && col >= 0;
    }

    private static void findStartCoordinates(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'G') {
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }
    
    private static void printMatrix(char[][] matrix) {
        matrix[row][col] = 'G';
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
