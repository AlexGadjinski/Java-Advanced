package vintageLocos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() == capacity) {
            System.out.println("This train station is full!");
        } else if (railGauge != locomotive.getGauge()) {
            System.out.printf("The rail gauge of this station does not match the locomotive gauge! " +
                    "Difference: %d mm.\n", Math.abs(railGauge - locomotive.getGauge()));
        } else {
            locomotives.add(locomotive);
        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(l -> l.getName().equals(name));
    }

    public String getFastestLocomotive() {
        Locomotive locomotive = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).orElse(null);
        if (locomotive == null) {
            return "There are no locomotives.";
        } else {
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                    locomotive.getName(), locomotive.getMaxSpeed());
        }
    }

    public Locomotive getLocomotive(String name) {
        return locomotives.stream()
                .filter(l -> l.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {
        if (locomotives.size() == 0) {
            return "There are no locomotives.";
        }
//        return locomotives.stream()
//                .sorted(Comparator.comparing(l -> l.getBuildDate())
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Locomotive oldestLocomotive = locomotives.get(0);

        int[] oldestDate = Arrays.stream(LocalDate.from(oldestLocomotive.getBuildDate()).format(formatter).split("\\."))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < locomotives.size(); i++) {
            Locomotive locomotive = locomotives.get(i);
            int[] currentDate = Arrays.stream(LocalDate.from(locomotive.getBuildDate()).format(formatter).split("\\."))
                    .mapToInt(Integer::parseInt).toArray();

            if (currentDate[0] < oldestDate[0]) {
                oldestLocomotive = locomotive;
                oldestDate = currentDate;
            } else if (currentDate[0] == oldestDate[0]) {
                if (currentDate[1] < oldestDate[1]) {
                    oldestLocomotive = locomotive;
                    oldestDate = currentDate;
                } else if (currentDate[1] == oldestDate[1]) {
                    if (currentDate[2] < oldestDate[2]) {
                        oldestLocomotive = locomotive;
                        oldestDate = currentDate;
                    }
                }
            }
        }
        return oldestLocomotive.getName();
    }

    public String getStatistics() {
        if (locomotives.size() == 0) {
            return String.format("There are no locomotives departing from %s station.", name);
        } else {
            AtomicReference<Integer> counter = new AtomicReference<>(1);
            return String.format("Locomotives departed from %s:\n", name)
                    + locomotives.stream()
                    .map(l -> String.format("%d. %s", counter.getAndSet(counter.get() + 1), l.getName()))
                    .collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
