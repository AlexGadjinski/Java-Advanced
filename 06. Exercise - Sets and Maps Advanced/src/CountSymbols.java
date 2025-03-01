import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbolsInfo = new TreeMap<>();

        for (char symbol : scanner.nextLine().toCharArray()) {
            symbolsInfo.putIfAbsent(symbol, 0);
            symbolsInfo.put(symbol, symbolsInfo.get(symbol) + 1);
        }

        symbolsInfo.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));
    }
}
