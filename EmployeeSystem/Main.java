package EmployeeSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Developer("Biswas", "D001", Department.DEVELOPMENT, 80000),
            new Tester("Anjali", "T001", Department.TESTING, 60000)
        );

        for(Employee emp: employees) {
            emp.displayInfo();
            System.out.println("Salary: $" + emp.calculateSalary());
            System.out.println("Bonus: $" + emp.calculateBonus());
            System.out.println("-----------------------");
        }
    }
}
