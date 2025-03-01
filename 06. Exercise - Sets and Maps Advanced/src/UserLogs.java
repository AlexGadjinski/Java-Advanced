import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            String IP = input.split(" ")[0].substring(3);
            String user = input.split(" ")[2].substring(5);

            userLogs.putIfAbsent(user, new LinkedHashMap<>());
            userLogs.get(user).putIfAbsent(IP, 0);
            int numberOfMessages = userLogs.get(user).get(IP) + 1;
            userLogs.get(user).put(IP, numberOfMessages);
        }

        for (var entry : userLogs.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            String activity = entry.getValue().entrySet().stream()
                    .map(innerEntry -> String.format("%s => %d", innerEntry.getKey(), innerEntry.getValue()))
                    .collect(Collectors.joining(", "));
            System.out.println(activity + ".");
        }
    }
}
