import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] input = scanner.nextLine().toCharArray();

        for (char parenthesis : input) {
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty() || !areMatching(stack.pop(), parenthesis)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean areMatching(char openParenthesis, char closeParenthesis) {
        if (openParenthesis == '{') {
            return closeParenthesis == '}';
        } else if (openParenthesis == '(') {
            return closeParenthesis == ')';
        } else {
            return closeParenthesis == ']';
        }
    }
}
