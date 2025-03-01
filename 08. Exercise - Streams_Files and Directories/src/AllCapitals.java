import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            writer.println(line.toUpperCase());
        }

        writer.close();
    }
}
