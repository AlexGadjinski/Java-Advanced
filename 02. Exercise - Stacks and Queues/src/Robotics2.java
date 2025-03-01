import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robotics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] names = Arrays.stream(input.split(";"))
                .map(s -> s.split("-")[0])
                .toArray(String[]::new);

        int[] processTimes = Arrays.stream(input.split(";"))
                .mapToInt(s -> Integer.parseInt(s.split("-")[1]))
                .toArray();

        String[] time = scanner.nextLine().split(":");

        ArrayDeque<String> products = Stream.generate(scanner::nextLine)
                .takeWhile(line -> !line.equals("End"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int[] assemblyLine = processTimes.clone();

        addTime(time);
        while (!products.isEmpty()) {
            boolean productTaken = false;
            int indexOfLastRobot = -1;
            for (int i = 0; i < assemblyLine.length; i++) {
                if (productTaken) {
                    for (int j = indexOfLastRobot + 1; j < assemblyLine.length; j++) {
                        if (assemblyLine[j] < processTimes[j]) {
                            if (--assemblyLine[j] == 0) {
                                assemblyLine[j] = processTimes[j];
                            }
                        }
                    }
                   break;
                }
                if (assemblyLine[i] == processTimes[i]) {
                    System.out.printf("%s - %s [%02d:%02d:%02d]\n", names[i], products.poll(),
                            Integer.parseInt(time[0]),
                            Integer.parseInt(time[1]),
                            Integer.parseInt(time[2]));
                    productTaken = true;
                    indexOfLastRobot = i;
                }
                if (--assemblyLine[i] == 0) {
                    assemblyLine[i] = processTimes[i];
                }
            }
            if (!productTaken) {
                products.offer(products.poll());
            }
            addTime(time);
        }
    }

    public static void addTime(String[] time) {
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        seconds += 1;
        if (seconds % 60 == 0) {
            seconds = 0;
            minutes += 1;
            if (minutes % 60 == 0) {
                minutes = 0;
                hours += 1;
                if (hours % 24 == 0) {
                    hours = 0;
                }
            }
        }

        time[0] = hours + "";
        time[1] = minutes + "";
        time[2] = seconds + "";
    }
}
