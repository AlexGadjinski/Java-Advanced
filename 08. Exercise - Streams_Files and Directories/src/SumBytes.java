import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        long sum = 0;

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }

            sum += Arrays.stream(line.split(""))
                    .mapToInt(e -> e.charAt(0))
                    .sum();
        }

        System.out.println(sum);
    }
}
