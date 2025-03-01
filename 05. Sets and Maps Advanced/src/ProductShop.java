import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shopsInfo = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");
            if (input[0].equals("Revision")) {
                break;
            }

            String shopName = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            shopsInfo.putIfAbsent(shopName, new LinkedHashMap<>());
            shopsInfo.get(shopName).put(product, price);
        }

        for (var shopEntry : shopsInfo.entrySet()) {
            System.out.println(shopEntry.getKey() + "->");
            for (Map.Entry<String, Double> productEntry : shopEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", productEntry.getKey(), productEntry.getValue());
            }
        }
    }
}
