import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {

        ArrayDeque<File> directories = new ArrayDeque<>();
        File root = new File("C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        directories.offer(root);

        PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced" +
                "\\Hausaufgaben\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\08.NestedFolders.txt"));
        int foldersCount = 1;

        while (!directories.isEmpty()) {
            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    directories.offer(f);
                    foldersCount++;
                }
            }
            writer.println(currentFile.getName());
        }

        writer.printf("%d folders", foldersCount);
        writer.close();
    }
}
