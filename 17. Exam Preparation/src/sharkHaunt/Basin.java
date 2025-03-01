package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basin {
    private List<Shark> sharks;
    private String name;
    private int capacity;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() == capacity) {
            System.out.println("This basin is at full capacity!");
        } else {
            sharks.add(shark);
        }
    }

    public boolean removeShark(String kind) {
        return sharks.removeIf(s -> s.getKind().equals(kind));
    }

    public Shark getLargestShark() {
//        return sharks.stream().sorted(Comparator.comparing(Shark::getLength).reversed()).toList().get(0);
        return sharks.stream().max(Comparator.comparing(Shark::getLength))
                .orElse(null);
    }

    public Shark getShark(String kind) {
//        for (Shark s : sharks) {
//            if (s.getKind().equals(kind)) {
//                return s;
//            }
//        }
//        return null;
        return sharks.stream()
                .filter(s -> s.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
//        return (int) sharks.stream()
//                .mapToInt(Shark::getLength)
//                .average().getAsDouble();
        return sharks.stream().mapToInt(Shark::getLength).sum() / sharks.size();
    }

    public String report() {
        return String.format("Sharks in %s:\n", name)
                + sharks.stream()
                .map(Shark::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
