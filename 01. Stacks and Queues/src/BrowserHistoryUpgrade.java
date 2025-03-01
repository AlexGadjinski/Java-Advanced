import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackUrlBack = new ArrayDeque<>();
        ArrayDeque<String> stackUrlForward = new ArrayDeque<>();


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                return;
            }

            if ("back".equals(input)) {
                if (stackUrlBack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String lastPage = stackUrlBack.pop();
                    stackUrlForward.push(lastPage);
                    System.out.println(stackUrlBack.peek());
                }
            } else if ("forward".equals(input)) {
                if (stackUrlForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    stackUrlBack.push(stackUrlForward.pop());
                    System.out.println(stackUrlBack.peek());
                }
            } else {
                stackUrlBack.push(input);
                stackUrlForward.clear();
                System.out.println(input);
            }
        }
    }
}
