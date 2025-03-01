import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stackOfSymbols = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (Character.isDigit(symbol) || Character.isLetter(symbol)) {
                System.out.print(symbol);
                if (i + 1 == input.length() || !Character.isDigit(input.charAt(i + 1))) {
                    System.out.print(" ");
                }
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                if (stackOfSymbols.isEmpty() || stackOfSymbols.peek() == '(') {
                    stackOfSymbols.push(symbol);
                } else {
                    if (!hasHigherPrecedence(symbol, stackOfSymbols.peek())) {
                        System.out.print(stackOfSymbols.pop() + " ");
                    }
                    stackOfSymbols.push(symbol);
                }
            } else if (symbol == '(') {
                stackOfSymbols.push(symbol);
            } else if (symbol == ')') {
                while (stackOfSymbols.peek() != '(') {
                    System.out.print(stackOfSymbols.pop() + " ");
                }
                stackOfSymbols.pop();
            }
        }

        while (!stackOfSymbols.isEmpty()) {
            System.out.print(stackOfSymbols.pop() + " ");
        }
    }

    public static boolean hasHigherPrecedence(char symbol1, char symbol2) {
        return switch (symbol1) {
            case '-', '+' -> false;
            case '*', '/' -> switch (symbol2) {
                case '+', '-' -> true;
                case '*', '/' -> false;
                default -> throw new IllegalStateException("Unexpected value: " + symbol2);
            };
            default -> throw new IllegalStateException("Unexpected value: " + symbol1);
        };
    }
}
