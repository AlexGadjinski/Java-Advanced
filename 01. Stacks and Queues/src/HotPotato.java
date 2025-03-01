import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> peopleQueue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            peopleQueue.offer(s);
        }

        int tossNum = Integer.parseInt(scanner.nextLine());

        while (peopleQueue.size() > 1) {
            for (int i = 1; i < tossNum; i++) {
                String person = peopleQueue.poll();
                peopleQueue.offer(person);
            }
            System.out.printf("Removed %s\n", peopleQueue.poll());
        }
        System.out.printf("Last is %s", peopleQueue.poll());
    }
}
