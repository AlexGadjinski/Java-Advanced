import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ListFiles {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        File[] files = file.listFiles();

        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\alexg\\Desktop\\" +
                "SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\07.ListFiles.txt"));

        for (File f : files) {
            if (!f.isDirectory()) {
                writer.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }

        writer.close();
    }
}
