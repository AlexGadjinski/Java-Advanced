package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("End")) {
                break;
            }

            Person person = getPerson(people, input[0]);
            switch (input[1]) {
                case "company" -> {
                    Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                    person.setCompany(company);
                }
                case "car" -> {
                    Car car = new Car(input[2], Integer.parseInt(input[3]));
                    person.setCar(car);
                }
                case "pokemon" -> {
                    Pokemon pokemon = new Pokemon(input[2], input[3]);
                    person.addPokemon(pokemon);
                }
                case "parents" -> {
                    Parent parent = new Parent(input[2], input[3]);
                    person.addParent(parent);
                }
                case "children" -> {
                    Child child = new Child(input[2], input[3]);
                    person.addChild(child);
                }
            }
        }

        String personName = scanner.nextLine();
        people.stream()
                .filter(p -> p.getName().equals(personName))
                .forEach(System.out::println);
    }

    private static Person getPerson(List<Person> people, String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        Person person = new Person(name);
        people.add(person);
        return person;
    }
}
