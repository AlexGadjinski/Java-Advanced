import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();

        boolean isNegative = false;
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 0) {
            System.out.println(input);
            return;
        } else if (input < 0) {
            isNegative = true;
            input *= -1;
        }

        while (input != 0) {
            int remainder = input % 2;
            input /= 2;
            binaryNum.push(remainder);
        }
        if (isNegative) {
            System.out.print("-" + binaryNum.pop());
        }

        while (!binaryNum.isEmpty()) {
            System.out.print(binaryNum.pop());
        }
    }
}
