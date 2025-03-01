import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String inputAddress = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputAddress = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        Path inputPath = Paths.get(inputAddress);
        Path outputPath = Paths.get(outputAddress);

        List<String> lines = Files.readAllLines(inputPath).stream()
                .filter(l -> !l.isBlank())
                .sorted()
                .toList();

        Files.write(outputPath, lines);
    }
}
