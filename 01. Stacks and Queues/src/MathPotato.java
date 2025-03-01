import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> peopleQueue = new PriorityQueue<>();

        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            peopleQueue.offer(s);
        }

        int tossNum = Integer.parseInt(scanner.nextLine());

        int cycle = 1;
        while (peopleQueue.size() > 1) {
            for (int i = 1; i < tossNum; i++) {
                String person = peopleQueue.poll();
                peopleQueue.offer(person);
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + peopleQueue.peek());
            } else {
                System.out.println("Removed " + peopleQueue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + peopleQueue.poll());
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
