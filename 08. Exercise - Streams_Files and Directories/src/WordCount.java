import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {

//        ГРЕШНО УСЛОВИЕ НА ЗАДАЧАТА ИЛИ ТЕСТОВЕ В judge,
//        НИКЪДЕ НЕ СЕ ИСКА Descending order sort, нито пък case insensitive

        String inputPath1 = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPath2 = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        String textToCheck = Files.readString(Paths.get(inputPath2));

        for (String word : Files.readString(Paths.get(inputPath1)).split(" ")) {
            words.putIfAbsent(word, 0);
            for (String current : textToCheck.split(" ")) {
                if (current.equals(word)) {
                    words.put(word, words.get(word) + 1);
                }
            }
        }

        words.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();
    }
}
