import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String inputPath1 = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPath2 = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\07.MergeTwoFiles.txt";

        String content1 = Files.readString(Paths.get(inputPath1));
        String content2 = Files.readString(Paths.get(inputPath2));

        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        writer.printf("%s\n%s", content1, content2);

        writer.close();
    }
}
