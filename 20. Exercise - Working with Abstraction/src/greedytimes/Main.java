package greedytimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    static long goldAmount = 0;
    static long gemAmount = 0;
    static long cashAmount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] tokens = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        long totalAmountOfItems = 0;
        for (int i = 0; i < tokens.length; i += 2) {
            String itemName = tokens[i];
            long amount = Long.parseLong(tokens[i + 1]);
            String itemType = findItemType(itemName);

            if (validToAdd(bagCapacity, totalAmountOfItems, amount, itemType)) {
                addItems(bag, itemName, amount, itemType);
                totalAmountOfItems += amount;
            }
        }
        printBag(bag);
    }

    private static void addItems(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, String itemName, long amount, String itemType) {
        bag.putIfAbsent(itemType, new LinkedHashMap<>());
        switch (itemType) {
            case "Gold" -> {
                goldAmount += amount;
                bag.get("Gold").put("Gold", goldAmount);
            }
            case "Gem" -> {
                gemAmount += amount;
                String material = bag.get("Gem").keySet().stream()
                        .filter(e -> e.equalsIgnoreCase(itemName))
                        .findFirst()
                        .orElse(itemName);
                bag.get("Gem").putIfAbsent(material, 0L);
                bag.get("Gem").put(material, bag.get("Gem").get(material) + amount);
            }
            case "Cash" -> {
                cashAmount += amount;
                bag.get("Cash").putIfAbsent(itemName, 0L);
                bag.get("Cash").put(itemName, bag.get("Cash").get(itemName) + amount);
            }
        }
    }

    private static boolean validToAdd(long bagCapacity, long totalAmountOfItems, long amount, String itemType) {
        if (totalAmountOfItems + amount > bagCapacity) {
            return false;
        }
        return switch (itemType) {
            case "Cash" -> cashAmount + amount <= gemAmount;
            case "Gem" -> gemAmount + amount <= goldAmount;
            case "Gold" -> true;
            default -> false;
        };
    }

    private static void printBag(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (var entry : bag.entrySet()) {

            System.out.printf("<%s> $%s\n", entry.getKey(), getTreasureAmount(entry.getKey()));
            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(innerEntry -> System.out.println("##" + innerEntry.getKey() + " - " + innerEntry.getValue()));
        }
    }

    private static long getTreasureAmount(String material) {
        return switch (material) {
            case "Cash" -> cashAmount;
            case "Gem" -> gemAmount;
            case "Gold" -> goldAmount;
            default -> throw new IllegalArgumentException("Unsupported material");
        };
    }

    private static String findItemType(String itemName) {
        if (itemName.length() == 3) {
            return "Cash";
        } else if (itemName.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (itemName.equalsIgnoreCase("gold")) {
            return "Gold";
        }
        return "";
    }
}
