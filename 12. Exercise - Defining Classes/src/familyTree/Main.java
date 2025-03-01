package familyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mainPersonInfo = scanner.nextLine();

        List<String> peopleLines = new ArrayList<>();
        List<String> relationLines = new ArrayList<>();

        readLines(peopleLines, relationLines, scanner);

        List<Person> people = new ArrayList<>();

        peopleLines.forEach(info -> {
            int index = info.lastIndexOf(" ");
            String name = info.substring(0, index);
            String birthdate = info.substring(index + 1);
            Person p = new Person(name, birthdate);
            people.add(p);
        });

        for (String line : relationLines) {
            Person parent = getPerson(people, line.split(" - ")[0]);
            Person child = getPerson(people, line.split(" - ")[1]);

            parent.addChild(child);
            child.addParent(parent);
        }

        Person personToPrint = getPerson(people, mainPersonInfo);
        System.out.println(personToPrint.toString());
    }

    private static Person getPerson(List<Person> people, String info) {
        for (Person person : people) {
            if (person.getName().equals(info) || person.getBirthdate().equals(info)) {
                return person;
            }
        }
        return null;
    }

    private static void readLines(List<String> peopleLines, List<String> relationLines, Scanner scanner) {
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }

            if (line.contains("-")) {
                relationLines.add(line);
            } else {
                peopleLines.add(line);
            }
        }
    }
}
