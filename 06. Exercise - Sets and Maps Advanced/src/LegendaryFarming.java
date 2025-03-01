import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int newQuantity = keyMaterials.get(material) + quantity;
                    keyMaterials.put(material, newQuantity);
                    if (weaponIsObtained(keyMaterials)) {
                        printRemaining(keyMaterials, junk);
                        return;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    int newQuantity = junk.get(material) + quantity;
                    junk.put(material, newQuantity);
                }
            }
        }
    }

    public static boolean weaponIsObtained(TreeMap<String, Integer> keyMaterials) {
        for (var entry : keyMaterials.entrySet()) {
            if (entry.getValue() >= 250) {
                String weapon = switch (entry.getKey()) {
                    case "shards" -> "Shadowmourne";
                    case "fragments" -> "Valanyr";
                    case "motes" -> "Dragonwrath";
                    default -> "";
                };
                System.out.printf("%s obtained!\n", weapon);
                keyMaterials.put(entry.getKey(), entry.getValue() - 250);
                return true;
            }
        }
        return false;
    }

    public static void printRemaining(TreeMap<String, Integer> keyMaterials, TreeMap<String, Integer> junk) {
        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .forEach(entry -> System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()));

        junk.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
