import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        while (true) {
            int asciiCode = inputStream.read();
            if (asciiCode == -1) {
                break;
            }

            System.out.print(Integer.toBinaryString(asciiCode) + " ");
        }

//        try {
//            FileInputStream inputStream = new FileInputStream(path);
//        } catch (FileNotFoundException exception) {
//            System.out.println("File not found!\n" + path);
//        } finally {
//            System.out.println("I am always executed!");
//        }
    }
}
