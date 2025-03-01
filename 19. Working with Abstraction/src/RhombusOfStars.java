import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);
        printBottom(n);
    }

    private static void printTop(int n) {
        for (int r = 1; r <= n; r++) {
            printRow(r, n);
        }
    }

    private static void printBottom(int n) {
        for (int r = n - 1; r >= 1; r--) {
            printRow(r, n);
        }
    }

    private static void printRow(int r, int n) {
        // printing spaces
        for (int i = 1; i <= n - r; i++) {
            System.out.print(" ");
        }
        
        //printing stars
        for (int i = 1; i <= r; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
