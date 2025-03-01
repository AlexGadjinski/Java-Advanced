package companyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];

            String email = "n/a";
            int age = -1;

            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            }

            Employee employee = new Employee(name, salary, position, email, age);
            Department department = getDepartment(departments, departmentName);
            department.addEmployee(employee);
        }

        Collections.sort(departments, Comparator.comparing(Department::getAverageSalary).reversed());
        Department highestPaidDepartment = departments.get(0);

        System.out.printf("Highest Average Salary: %s\n", highestPaidDepartment.getName());
        System.out.print(highestPaidDepartment);
    }

    private static Department getDepartment(List<Department> departments, String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        Department department = new Department(departmentName);
        departments.add(department);
        return department;
    }
}
