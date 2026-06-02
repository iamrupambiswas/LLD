package EmployeeSystem;

abstract class Employee {
    private String name;
    private String id;
    private Department department;
    private double salary;

    public Employee(String name, String id, Department department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
    }

    public double calculateSalary() {
        return salary;
    }

    abstract double calculateBonus();
}