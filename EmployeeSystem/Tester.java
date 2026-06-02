package EmployeeSystem;

public class Tester extends Employee {

    public Tester(String name, String id, Department department, double salary){
        super(name, id, department, salary);
    }

    @Override
    double calculateBonus() {
        return calculateSalary() * 0.05;
    }
    
}
