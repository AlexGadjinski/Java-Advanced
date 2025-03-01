package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    int badges;
    List<Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
    void checkElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                badges++;
                return;
            }
        }
        pokemons.removeIf(pokemon -> pokemon.loseHealth() <= 0);
    }

    String getName() {
        return name;
    }

    int getBadges() {
        return badges;
    }


    int getPokemonsNum() {
        return pokemons.size();
    }
}
