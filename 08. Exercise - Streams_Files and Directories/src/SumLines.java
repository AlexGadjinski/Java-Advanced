import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }

            int sum = Arrays.stream(line.split(""))
                    .mapToInt(c -> c.charAt(0))
                    .sum();
            System.out.println(sum);
        }
    }
}
