import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> expressionIndexes = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                expressionIndexes.push(i);
            } else if (input.charAt(i) == ')') {
                String expression = input.substring(expressionIndexes.pop(), i + 1);
                System.out.println(expression);
            }
        }
    }
}
