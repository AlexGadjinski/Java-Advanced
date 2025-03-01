import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, double[]> studentInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToDouble(Double::parseDouble).toArray();

            studentInfo.put(student, grades);
        }

        for (var entry : studentInfo.entrySet()) {
            double gradesSum = 0;
            for (Double grade : entry.getValue()) {
                gradesSum += grade;
            }
            System.out.printf("%s is graduated with %s\n", entry.getKey(), gradesSum / entry.getValue().length);
        }
    }
}
