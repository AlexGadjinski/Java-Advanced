import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phoneContacts = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("-");
            if (input[0].equals("search")) {
                break;
            }

            String name = input[0];
            String phoneNumber = input[1];
            phoneContacts.put(name, phoneNumber);
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }

            String name = input;
            if (phoneContacts.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, phoneContacts.get(name));
            } else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
        }
    }
}
