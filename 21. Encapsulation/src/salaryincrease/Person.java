package salaryincrease;

import java.text.DecimalFormat;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double percentBonus) {
        if (age < 30) {
            percentBonus /= 2;
        }
        salary = salary + (salary * percentBonus / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", firstName, lastName, new DecimalFormat("0.0####").format(salary));
    }
}
