package validationdata;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setFirstName(String firstName) {
        validateName(firstName, "First");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        validateName(lastName, "Last");
        this.lastName = lastName;
    }

    private void validateName(String name, String errorPrefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(errorPrefix + " name cannot be less than 3 symbols");
        }
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
