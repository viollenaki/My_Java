// Step 1: Abstract Class Employee
abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Step 2: Payable Interface
interface Payable {
    double getPaymentAmount();
}

// Step 3: FullTimeEmployee Class
class FullTimeEmployee extends Employee implements Payable {
    public FullTimeEmployee(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.2; // 20% extra
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

// Step 4: ContractEmployee Class
class ContractEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id, 0); // Base salary not applicable for contract employees
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

// Step 5: Main Class to Test the System
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
