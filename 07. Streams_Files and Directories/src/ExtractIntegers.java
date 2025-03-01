import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            } else {
                scanner.next();
            }
        }

        writer.close();
    }
}
