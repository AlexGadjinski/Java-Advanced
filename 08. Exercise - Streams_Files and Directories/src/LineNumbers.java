import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        List<String> lines = Files.readAllLines(Paths.get(inputPath));

        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        int counter = 1;
        for (String line : lines) {
            writer.printf("%d. %s\n", counter++, line);
        }

        writer.close();
    }
}
