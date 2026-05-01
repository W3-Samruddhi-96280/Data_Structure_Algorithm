package Day4;

public class Employee {
    int empid;
    String name;
    double salary;

    public Employee(int empid, String name, double salary) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-10s | Salary: %.2f", empid, name, salary);
    }
}
