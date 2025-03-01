import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");

            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]) {
                case "IN" -> parkingLot.add(input[1]);
                case "OUT" -> parkingLot.remove(input[1]);
            }
        }

        String output = parkingLot.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), parkingLot);
        System.out.println(output);
    }
}
