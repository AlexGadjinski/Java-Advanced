import java.util.Scanner;

public class RecursiveFibonacci {

    static long[] fibonacciNums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        fibonacciNums = new long[n + 1];

        System.out.println(getFibonacci(n));

        //If you want to figure out how to skip those unnecessary calculations,
        //you can search for a technique called memoization.
    }

    public static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            if (fibonacciNums[n] != 0) {
                return fibonacciNums[n];
            }
            long fibNum = getFibonacci(n - 1) + getFibonacci(n - 2);
            fibonacciNums[n] = fibNum;

            return fibNum;
        }
    }
}
