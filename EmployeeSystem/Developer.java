package EmployeeSystem;

public class Developer extends Employee {

    public Developer(String name, String id, Department department, double salary) {
        super(name, id, department, salary);
    }

    @Override
    double calculateBonus() {
        return calculateSalary() * 0.1;
    }
}
