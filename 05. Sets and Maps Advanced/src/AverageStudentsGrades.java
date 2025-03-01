import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }

        for (var entry : studentsGrades.entrySet()) {
            String name = entry.getKey();
            String grades = entry.getValue().stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));
            double avg = entry.getValue().stream()
                    .mapToDouble(g -> g)
                    .average()
                    .getAsDouble();

            System.out.printf("%s -> %s (avg: %.2f)\n", name, grades, avg);
        }

//        for (var entry : studentsGrades.entrySet()) {
//            String name = entry.getKey();
//            String grades = "";
//            double sum = 0;
//
//            for (Double grade : entry.getValue()) {
//                grades += String.format("%.2f ", grade);
//                sum += grade;
//            }
//
//            System.out.printf("%s -> %s(avg: %.2f)\n", name, grades, sum / entry.getValue().size());
//        }
    }
}
