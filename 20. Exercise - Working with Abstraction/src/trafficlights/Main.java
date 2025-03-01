package trafficlights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> trafficLights = Arrays.stream(scanner.nextLine().split(" "))
                .map(TrafficLight::new)
                .toList();

        int updates = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < updates; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.updateSignal();
                System.out.print(trafficLight.getSignal() + " ");
            }
            System.out.println();
        }
    }
}
