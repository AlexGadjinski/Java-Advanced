import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        int folderSize = 0;

        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
