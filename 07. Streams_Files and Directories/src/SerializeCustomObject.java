import java.io.*;

public class SerializeCustomObject {

    public static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;

        Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        String path = "C:\\Users\\alexg\\Desktop\\SoftUni Java Advanced\\Hausaufgaben\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\09.SerializeCustomObject.txt";

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject(cube);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj = inputStream.readObject();
    }
}
