import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Nuke it from orbit")) {
                break;
            }
            int rowToDestroy = Integer.parseInt(command.split(" ")[0]);
            int colToDestroy = Integer.parseInt(command.split(" ")[1]);
            int radius = Integer.parseInt(command.split(" ")[2]);

            destroyCells(matrix, rowToDestroy, colToDestroy, radius);
        }

        printMatrix(matrix);
    }

    private static void destroyCells(List<List<Integer>> matrix, int rowToDestroy, int colToDestroy, int radius) {

        boolean isChanged = false;
        int leftIndex = Math.max(colToDestroy - radius, 0);
        int rightIndex = colToDestroy + radius;
        int topIndex = Math.max(rowToDestroy - radius, 0);
        int bottomIndex = rowToDestroy + radius;

        int maxCols = 0;
        for (List<Integer> list : matrix) {
            int size = list.size();
            if (size > maxCols) {
                maxCols = size;
            }
        }

        if (leftIndex > maxCols || rightIndex < 0 || bottomIndex < 0 || topIndex > matrix.size()) {
            return;
        }

        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                if (r == rowToDestroy) {
                    if (c >= leftIndex && c <= rightIndex) {
                        matrix.get(r).set(c, -1);
                        isChanged = true;
                    }
                } else if (c == colToDestroy) {
                    if (r >= topIndex && r <= bottomIndex) {
                        matrix.get(r).set(c, -1);
                        isChanged = true;
                    }
                }
            }
        }
        if (!isChanged) {
            return;
        }

        matrix.forEach(list -> list.removeIf(n -> n == -1));
        matrix.removeIf(List::isEmpty);
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(num++);
            }
        }
    }
    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> list : matrix) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
