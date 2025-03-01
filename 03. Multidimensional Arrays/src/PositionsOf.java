import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstDimNum = input[0];
        int secondDimNum = input[1];

        int[][] matrix = new int[firstDimNum][secondDimNum];

        for (int i = 0; i < firstDimNum; i++) {
            int[] currentArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = currentArray;
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int i = 0; i < firstDimNum; i++) {
            for (int j = 0; j < secondDimNum; j++) {
                if (matrix[i][j] == numberToFind) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
