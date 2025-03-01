import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> peopleEmails = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }

            String name = input;
            String email = scanner.nextLine();

            String domain = email.substring(email.lastIndexOf('.') + 1).toLowerCase();

            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                peopleEmails.put(name, email);
            }
        }

        peopleEmails.forEach((name, email) -> System.out.printf("%s -> %s\n", name, email));
    }
}
