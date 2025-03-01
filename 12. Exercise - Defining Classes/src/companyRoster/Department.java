package companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String name;
    private List<Employee> employees;

    Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum() / employees.size();
    }

    @Override
    public String toString() {
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());

        return employees.stream()
                .map(Employee::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
