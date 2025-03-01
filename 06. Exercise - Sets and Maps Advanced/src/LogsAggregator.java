import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeSet<String>> userIPs = new TreeMap<>();
        TreeMap<String, Integer> userActivityDuration = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String IP = input[0];
            String user = input[1];
            int session = Integer.parseInt(input[2]);

            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(IP);

            userActivityDuration.putIfAbsent(user, 0);
            userActivityDuration.put(user, userActivityDuration.get(user) + session);
        }

        userActivityDuration.forEach((user, duration) ->
                System.out.printf("%s: %d %s\n", user, duration, userIPs.get(user).toString()));
    }
}
