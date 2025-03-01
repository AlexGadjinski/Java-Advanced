import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationInfo = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesPopulation = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("report")) {
                break;
            }

            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).put(city, population);

            countriesPopulation.putIfAbsent(country, 0L);
            long totalPopulation = countriesPopulation.get(country) + population;
            countriesPopulation.put(country, totalPopulation);
        }

        countriesPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());

                    LinkedHashMap<String, Long> citiesPopulation = populationInfo.get(entry.getKey());

                    citiesPopulation.entrySet().stream()
                            .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                            .forEach(innerEntry -> System.out.printf("=>%s: %d\n", innerEntry.getKey(), innerEntry.getValue()));
                });
    }
}
