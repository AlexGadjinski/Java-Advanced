import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int playerHP = 18500;
        double heiganHP = 3000000;

        int[] playerCoordinates = {7, 7};
        boolean cloudToHit = false;

        while (true) {
            heiganHP -= damageToHeigan;
            if (cloudToHit) {
                playerHP -= 3500;
                cloudToHit = false;
            }
            if (heiganHP <= 0 || playerHP <= 0) {
                printResults(heiganHP, playerHP, playerCoordinates, "Plague Cloud");
                return;
            }

            String[][] matrix = new String[15][15];
            String[] input = scanner.nextLine().split(" ");

            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            boolean movementIsNeeded = false;

            for (int r = row - 1; r <= row + 1; r++) {
                if (r == -1) {
                    continue;
                } else if (r == 15) {
                    break;
                }
                for (int c = col - 1; c <= col + 1; c++) {
                    if (c == -1) {
                        continue;
                    } else if (c == 15) {
                        break;
                    }

                    if (r == playerRow && c == playerCol) {
                        movementIsNeeded = true;
                    }
                    matrix[r][c] = "damaged";
                }
            }
            if (movementIsNeeded) {
                movePlayer(matrix, playerCoordinates);
                if (playerCoordinates[0] == playerRow && playerCoordinates[1] == playerCol) {
                    switch (spell) {
                        case "Cloud" -> {
                            playerHP -= 3500;
                            cloudToHit = true;
                            spell = "Plague Cloud";
                        }
                        case "Eruption" -> playerHP -= 6000;
                    }
                    if (playerHP <= 0) {
                        printResults(heiganHP, playerHP, playerCoordinates, spell);
                        return;
                    }
                }
            }
        }
    }

    private static void printResults(double heiganHP, int playerHP, int[] playerCoordinates, String spell) {
        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
            if (playerHP <= 0) {
                System.out.println("Player: Killed by Plague Cloud\n");
            } else {
                System.out.printf("Player: %d\n", playerHP);
            }
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHP);
            System.out.println("Player: Killed by " + spell);
        }
        System.out.printf("Final position: %d, %d", playerCoordinates[0], playerCoordinates[1]);
    }

    private static void movePlayer(String[][] matrix, int[] playerCoordinates) {
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];

        if (playerRow > 0 && !"damaged".equals(matrix[playerRow - 1][playerCol])) {
            playerCoordinates[0] = playerRow - 1;
        } else if (playerCol < 14 && !"damaged".equals(matrix[playerRow][playerCol + 1])) {
            playerCoordinates[1] = playerCol + 1;
        } else if (playerRow < 14 && !"damaged".equals(matrix[playerRow + 1][playerCol])) {
            playerCoordinates[0] = playerRow + 1;
        } else if (playerCol > 0 && !"damaged".equals(matrix[playerRow][playerCol - 1])) {
            playerCoordinates[1] = playerCol - 1;
        }
    }
}
