package google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    Person(String name) {
        this.name = name;
        parents = new ArrayList<>();
        children = new ArrayList<>();
        pokemons = new ArrayList<>();
    }

    void setCompany(Company company) {
        this.company = company;
    }

    void setCar(Car car) {
        this.car = car;
    }

    String getName() {
        return name;
    }

    void addParent(Parent parent) {
        parents.add(parent);
    }

    void addChild(Child child) {
        children.add(child);
    }

    void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        String companyPrint = company == null
                ? ""
                : company + "\n";
        String carPrint = car == null
                ? ""
                : car + "\n";
        String pokemonsPrint = pokemons.isEmpty()
                ? ""
                : pokemons.stream().map(Pokemon::toString).collect(Collectors.joining(System.lineSeparator())) + "\n";
        String parentsPrint = parents.isEmpty()
                ? ""
                : parents.stream().map(Parent::toString).collect(Collectors.joining(System.lineSeparator())) + "\n";
        String childrenPrint = children.isEmpty()
                ? ""
                : children.stream().map(Child::toString).collect(Collectors.joining(System.lineSeparator())) + "\n";


        return name + "\n" + "Company:\n" + companyPrint + "Car:\n" + carPrint
                + "Pokemon:\n" + pokemonsPrint + "Parents:\n" + parentsPrint + "Children:\n" + childrenPrint;
    }
}
