package bordercontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> objects = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            Identifiable obj = getIdentifiableObj(tokens);

            objects.add(obj);
            input = scanner.nextLine();
        }

        String fakeIdSuffix = scanner.nextLine();
        printFakeIds(fakeIdSuffix, objects);
    }

    private static void printFakeIds(String fakeIdSuffix, List<Identifiable> objects) {
        objects.stream()
                .filter(o -> o.getId().endsWith(fakeIdSuffix))
                .forEach(o -> System.out.println(o.getId()));
    }

    private static Identifiable getIdentifiableObj(String[] tokens) {
        return switch (tokens.length) {
            case 3 -> {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                yield new Citizen(name, age, id);
            }
            case 2 -> {
                String model = tokens[0];
                String id = tokens[1];
                yield new Robot(model, id);
            }
            default -> throw new IllegalArgumentException("Invalid input provided");
        };
    }
}
