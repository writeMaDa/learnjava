import java.util.ArrayList;
import java.util.List;

class Employee {
    protected String name;
    protected String employeeId;
    protected double salary;

    public Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public double calculatePay() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId + ", Salary: " + calculatePay();
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, String employeeId, double salary, double bonus) {
        super(name, employeeId, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return salary + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId, hourlyRate * hoursWorked);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

interface EmployeeManager {
    void addEmployee(Employee employee);
    void removeEmployee(String employeeId);
    void displayAllEmployees();
}

class Company implements EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).employeeId.equals(employeeId)) {
                employees.remove(i);
                break;
            }
        }
    }

    @Override
    public void displayAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

public class EmployeeManage {
    public static void main(String[] args) {
        Company company = new Company();

        Employee ft1 = new FullTimeEmployee("LEE", "Full001", 50000, 5000);
        Employee pt1 = new PartTimeEmployee("PARK", "Part001", 20, 120);

        company.addEmployee(ft1);
        company.addEmployee(pt1);

        Employee ft2 = new FullTimeEmployee("KIM", "Full002", 60000, 7000);
        Employee pt2 = new PartTimeEmployee("CHOI", "Part002", 25, 150);
        Employee ft3 = new FullTimeEmployee("JUNG", "Full003", 55000, 8000);

        company.addEmployee(ft2);
        company.addEmployee(pt2);
        company.addEmployee(ft3);

        System.out.println("모든 직원:");
        company.displayAllEmployees();

        company.removeEmployee("Part001");
        System.out.println("\nPart001 삭제\n");

        System.out.println("모든 직원:");
        company.displayAllEmployees();
    }
}
