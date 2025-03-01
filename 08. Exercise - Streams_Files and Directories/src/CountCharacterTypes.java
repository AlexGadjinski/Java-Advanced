import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        String content = Files.readString(Paths.get(inputPath));
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        int vowels = 0;
        int otherSymbols = 0;
        int punctuations = 0;

        for (char c : content.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                switch (c) {
                    case 'a', 'i', 'o', 'e', 'u' -> vowels++;
                    case '!', ',', '.', '?' -> punctuations++;
                    default -> otherSymbols++;
                }
            }
        }

        writer.printf("Vowels: %d\nOther symbols: %d\nPunctuation: %d", vowels, otherSymbols, punctuations);
        writer.close();
    }
}
