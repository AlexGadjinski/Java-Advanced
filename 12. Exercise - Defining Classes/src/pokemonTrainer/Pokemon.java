package pokemonTrainer;

public class Pokemon {
    String name;
    String element;
    int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    int loseHealth() {
        return health -= 10;
    }

    String getElement() {
        return element;
    }
}
