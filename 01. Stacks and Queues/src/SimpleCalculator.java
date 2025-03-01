import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbersInput = input.split(" [+-] ");
        String[] operators = new String[numbersInput.length - 1];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                operators[counter++] = input.charAt(i) + "";
            }
        }
        stack.push(Integer.parseInt(numbersInput[0]));
        for (int i = 0; i < operators.length; i++) {
            stack.push(Integer.parseInt(operators[i] + numbersInput[i+1]));
        }

        while (stack.size() != 1) {
            int num1 = stack.pop();
            int num2 = stack.pop();
            stack.push(num1 + num2);
        }
        System.out.println(stack.peek());
    }
}
