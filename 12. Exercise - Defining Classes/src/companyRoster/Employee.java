package companyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
