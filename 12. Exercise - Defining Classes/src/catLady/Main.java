package catLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("End")) {
                break;
            }

            switch (input[0]) {
                case "Siamese" -> cats.add(new Siamese(input[1], Double.parseDouble(input[2])));
                case "Cymric" -> cats.add(new Cymric(input[1], Double.parseDouble(input[2])));
                case "StreetExtraordinaire" -> cats.add(new StreetExtraordinaire(input[1], Double.parseDouble(input[2])));
            }
        }

        String name = scanner.nextLine();
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                System.out.println(cat);
                return;
            }
        }
    }
}
