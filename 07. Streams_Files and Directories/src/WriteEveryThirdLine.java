import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));
//        PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

        int counter = 1;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            } else if (counter % 3 == 0) {
                writer.println(line);
            }
            counter++;
        }

        writer.close();
    }
}
