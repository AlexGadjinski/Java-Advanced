import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> compounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            compounds.addAll(List.of(scanner.nextLine().split(" ")));
        }

        compounds.forEach(e -> System.out.print(e + " "));
    }
}
