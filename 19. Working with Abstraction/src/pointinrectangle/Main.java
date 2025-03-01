package pointinrectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = parseRectangle(scanner.nextLine());

        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            Point point = parsePoint(scanner.nextLine());
            System.out.println(rectangle.contains(point));
        }
    }

    private static Point parsePoint(String input) {
        int[] coordinates = readArr(input);
        return new Point(coordinates[0], coordinates[1]);
    }

    private static Rectangle parseRectangle(String input) {
        int[] coordinates = readArr(input);
        return new Rectangle(new Point(coordinates[0], coordinates[1]), new Point(coordinates[2], coordinates[3]));
    }

    private static int[] readArr(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
