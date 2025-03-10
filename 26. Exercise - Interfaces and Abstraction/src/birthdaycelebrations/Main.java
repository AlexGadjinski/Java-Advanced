package birthdaycelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Citizen" -> birthableList.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                case "Pet" -> birthableList.add(new Pet(tokens[1], tokens[2]));
            }
            input = scanner.nextLine();
        }

        String yearOfBirth = scanner.nextLine();
        birthableList.stream()
                .filter(o -> o.getBirthDate().endsWith(yearOfBirth))
                .forEach(o -> System.out.println(o.getBirthDate()));
    }
}
