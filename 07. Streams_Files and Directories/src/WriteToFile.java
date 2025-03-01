import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            next = next.replaceAll("[,.!?]", "");
            for (char c : next.toCharArray()) {
                outputStream.write(c);
            }
            outputStream.write('\n');
        }

//        2 начин:
//        while (true) {
//            int asciiCode = inputStream.read();
//            if (asciiCode == -1) {
//                break;
//            }
//
//            if (asciiCode == ',' || asciiCode == '.' || asciiCode == '!' || asciiCode == '?') {
//                continue;
//            }
//            outputStream.write(asciiCode);
//        }
    }
}
