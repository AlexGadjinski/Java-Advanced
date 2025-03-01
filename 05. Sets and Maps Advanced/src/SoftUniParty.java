import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("PARTY")) {
                break;
            } else if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            vipGuests.remove(input);
            regularGuests.remove(input);
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }
    }
}
