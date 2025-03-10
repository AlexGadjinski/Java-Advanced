package studentsystem;

import java.util.HashMap;

public class StudentSystem {
    private HashMap<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public String parseCommand(String[] args) {
        String command = args[0];
        String name = args[1];

        String output = "";

        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            repo.putIfAbsent(name, new Student(name, age, grade));
            return "";
        }
        Student student = repo.get(name);
        if (student != null) {
            output = student.toString();
        }
        return output;
    }
}
