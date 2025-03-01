package studentsystem;

public record Student(String name, int age, double grade) {
    @Override
    public String toString() {
        return String.format("%s is %d years old. %s", name, age, getPostfix());
    }

    private String getPostfix() {
        if (grade >= 5.00) {
            return "Excellent student.";
        } else if (grade >= 3.50) {
            return "Average student.";
        } else {
            return "Very nice person.";
        }
    }
}
