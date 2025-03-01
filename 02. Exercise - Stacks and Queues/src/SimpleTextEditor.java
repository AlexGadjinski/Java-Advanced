import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> textHistory = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "1":
                    textHistory.push(text.toString());
                    text.append(input[1]);
                    break;
                case "2":
                    textHistory.push(text.toString());
                    int countToDelete = Integer.parseInt(input[1]);
                    text.delete(text.length() - countToDelete, text.length());
                    break;
                case "3":
                    int indexToPrint = Integer.parseInt(input[1]) - 1;
                    System.out.println(text.charAt(indexToPrint));
                    break;
                case "4":
                    text = new StringBuilder(textHistory.pop());
                    break;
            }
        }
    }
}
