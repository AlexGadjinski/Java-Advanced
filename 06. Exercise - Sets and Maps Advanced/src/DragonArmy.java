import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragonsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String type = input[0];
            String name = input[1];
            int damage = input[2].equals("null")
                    ? 45
                    : Integer.parseInt(input[2]);
            int health = input[3].equals("null")
                    ? 250
                    : Integer.parseInt(input[3]);
            int armor = input[4].equals("null")
                    ? 10
                    : Integer.parseInt(input[4]);

            dragonsInfo.putIfAbsent(type, new TreeMap<>());
            dragonsInfo.get(type).put(name, new ArrayList<>(List.of(damage, health, armor)));
        }

        dragonsInfo.entrySet().forEach(entry -> {
                    String type = entry.getKey();
                    double avrDamage = 0;
                    double avrHealth = 0;
                    double avrArmor = 0;

                    int numberOfDragons = 0;
                    for (var innerEntry : entry.getValue().entrySet()) {
                        avrDamage += innerEntry.getValue().get(0);
                        avrHealth += innerEntry.getValue().get(1);
                        avrArmor += innerEntry.getValue().get(2);
                        numberOfDragons++;
                    }
                    avrDamage /= numberOfDragons;
                    avrHealth /= numberOfDragons;
                    avrArmor /= numberOfDragons;

                    System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avrDamage, avrHealth, avrArmor);

                    entry.getValue().forEach((name, stats) ->
                            System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                                    name, stats.get(0), stats.get(1), stats.get(2)));
                });
    }
}
