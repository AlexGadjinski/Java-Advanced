package familyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private String birthdate;
    private List<Person> parents;
    private List<Person> children;

    Person(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    String getBirthdate() {
        return birthdate;
    }

    void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    void addParent(Person parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        String parentsToPrint = parents.isEmpty()
                ? ""
                : parents.stream()
                .map(p -> String.format("%s %s", p.getName(), p.getBirthdate()))
                .collect(Collectors.joining(System.lineSeparator())) + "\n";
        String childrenToPrint = children.isEmpty()
                ? ""
                : children.stream()
                .map(p -> String.format("%s %s", p.getName(), p.getBirthdate()))
                .collect(Collectors.joining(System.lineSeparator())) + "\n";
        return name + " " + birthdate + "\nParents:\n" + parentsToPrint + "Children:\n" + childrenToPrint;
    }
}
