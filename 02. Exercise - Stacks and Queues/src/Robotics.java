import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    static String[] time;
    String name;
    int processTime;
    String[] startTime;
    String[] freeTime;
    boolean isReadyToTakeProducts = true;

    Robotics(String name, int processTime) {
        this.name = name;
        this.processTime = processTime;
    }

    void takeProduct(String[] startTime) {
        this.startTime = startTime;
        freeTime = addTime(processTime, startTime);
        isReadyToTakeProducts = false;
    }

    void getFree() {
        if (startTime == null) {
            return;
        }
        if (String.join(":", freeTime).equals(String.join(":", time))) {
            isReadyToTakeProducts = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] specifics = scanner.nextLine().split(";");
        Robotics[] robots = new Robotics[specifics.length];

        int counter = 0;
        for (String specific : specifics) {
            String name = specific.split("-")[0];
            int processTime = Integer.parseInt(specific.split("-")[1]);

            robots[counter++] = new Robotics(name, processTime);
        }

        time = scanner.nextLine().split(":");
        if (time[0].length() == 1) {
            time[0] = String.format("0%s",time[0]);
        }

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        while (true) {
            String product = scanner.nextLine();
            if (product.equals("End")) {
                break;
            }
            productsQueue.offer(product);
        }

        while (true) {
            if (productsQueue.isEmpty()) {
                return;
            }
            time = addTime(1, time);
            for (Robotics robot : robots) {
                robot.getFree();
            }
            boolean noProductWasTaken = true;
            for (int i = 0; i < robots.length; i++) {
                Robotics robot = robots[i];
                if (robot.isReadyToTakeProducts) {
                    robot.takeProduct(time);
                    System.out.printf("%s - %s [%s]\n", robot.name, productsQueue.poll(),
                            String.join(":",time));
                    noProductWasTaken = false;
                    break;
                }
            }
            if (noProductWasTaken) {
                productsQueue.offer(productsQueue.poll());
            }
        }
    }

    static String[] addTime(int secondsToAdd, String[] time) {
        String[] resultTime = time.clone();
        int seconds = Integer.parseInt(time[2]);
        if (seconds + secondsToAdd <= 59) {
            seconds += secondsToAdd;
            resultTime[2] = String.format("%02d", seconds);
        } else {
            int newMinutesToAdd = (seconds + secondsToAdd) / 60;
            seconds = (seconds + secondsToAdd) % 60;
            resultTime[2] = String.format("%02d", seconds);
            int minutes = Integer.parseInt(time[1]);
            if (minutes + newMinutesToAdd <= 59) {
                minutes += newMinutesToAdd;
                resultTime[1] = String.format("%02d", minutes);
            } else {
                int newHoursToAdd = (minutes + newMinutesToAdd) / 60;
                minutes = (minutes + newMinutesToAdd) % 60;
                resultTime[1] = String.format("%02d", minutes);
                int hours = Integer.parseInt(time[0]);
                if (hours + newHoursToAdd <= 23) {
                    hours += newHoursToAdd;
                } else {
                    hours = (hours + newHoursToAdd) % 24;
                }
                resultTime[0] = String.format("%02d", hours);
            }
        }
        return resultTime;
    }
}
