package vintageLocos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Locomotive {
    private String name;
    private String builder;
    private LocalDate buildDate;
    private int gauge;
    private int weight;
    private int maxSpeed;

    public Locomotive(String name, String builder, LocalDate buildDate, int gauge, int weight, int maxSpeed) {
        this.name = name;
        this.builder = builder;
        this.buildDate = buildDate;
        this.gauge = gauge;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = LocalDate.from(getBuildDate()).format(formatter);

        return String.format("This %s is made by %s at %s\n", name, builder, formattedDate);
    }

    public TemporalAccessor getBuildDate() {
        return buildDate;
    }
    public int getGauge() {
        return gauge;
    }
    public String getName() {
        return name;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
}
