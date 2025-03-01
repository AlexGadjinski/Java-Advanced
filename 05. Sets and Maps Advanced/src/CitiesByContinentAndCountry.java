import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var innerEntry : entry.getValue().entrySet()) {
                String cities = String.join(", ", innerEntry.getValue());
                System.out.printf("\t%s -> %s\n", innerEntry.getKey(), cities);
            }
        }
    }
}

