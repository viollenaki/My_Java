abstract class Employee {
    protected String name;
    protected int id;
    protected double base;

    public Employee(String name, int id, double base) {
        this.name = name;
        this.id = id;
        this.base = base;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Payable {
    double getPaymentAmount();
}

class FullTimeEmployee extends Employee implements Payable {
    public FullTimeEmployee(String name, int id, double base) {
        super(name, id, base);
    }

    @Override
    public double calculateSalary() {
        return base * 1.2; 
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

class ContractEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id, 0); 
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Alice", 101, 5000);
        ContractEmployee contractEmp = new ContractEmployee("Bob", 102, 50, 160);

        System.out.println("Full-Time Employee Details:");
        fullTimeEmp.displayEmployeeInfo();
        System.out.println("\nContract Employee Details:");
        contractEmp.displayEmployeeInfo();
    }
}
