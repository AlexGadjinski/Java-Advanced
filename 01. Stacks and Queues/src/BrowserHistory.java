import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> url = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                return;
            }

            if ("back".equals(input)) {
                if (url.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    url.pop();
                    System.out.println(url.peek());
                }
            } else {
                url.push(input);
                System.out.println(input);
            }
        }
    }
}
