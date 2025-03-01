package pokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Tournament")) {
                break;
            }

            String trainerName = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer trainer = getTrainer(trainers, trainerName);
            trainer.addPokemon(pokemon);
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            trainers.forEach(t -> t.checkElement(input));
        }

        trainers.sort(Comparator.comparing(Trainer::getBadges).reversed());
        trainers.forEach(t -> System.out.printf("%s %d %d\n", t.getName(), t.getBadges(), t.getPokemonsNum()));
    }

    private static Trainer getTrainer(List<Trainer> trainers, String trainerName) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(trainerName)) {
                return trainer;
            }
        }
        Trainer trainer = new Trainer(trainerName);
        trainers.add(trainer);
        return trainer;
    }
}
