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
        System.out.println("Employee ID--- " + id);
        System.out.println("Name--- " + name);
        System.out.println("Salary--- " + calculateSalary());
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
    private double hourly;
    private int hours;

    public ContractEmployee(String name, int id, double hourly, int hours) {
        super(name, id, 0); 
        this.hourly = hourly;
        this.hours = hours;
    }

    @Override
    public double calculateSalary() {
        return hourly * hours;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee("John Doe", 1, 1000);
        employees[1] = new ContractEmployee("Jane Doe", 2, 20, 40);
        for (Employee e : employees){
            e.displayEmployeeInfo();
            System.out.println("Payment Amount: " + e.calculateSalary());
        }
    }
}
