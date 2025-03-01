import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printQueue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("print")) {
                while (!printQueue.isEmpty()) {
                    System.out.println(printQueue.poll());
                }
                return;
            }
            if (input.equals("cancel")) {
                if (printQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s\n", printQueue.poll());
                }
            } else {
                printQueue.offer(input);
            }
        }
    }
}
