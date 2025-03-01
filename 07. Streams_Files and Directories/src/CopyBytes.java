import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        PrintWriter writer = new PrintWriter(outputStream);

        while (true) {
            int asciiCode = inputStream.read();
            if (asciiCode == -1) {
                break;
            }

            if (asciiCode == ' ') {
                writer.print(' ');
            } else if (asciiCode == '\n') {
                writer.println();
            } else {
                writer.print(asciiCode);
            }
        }

        writer.close();
    }
}
