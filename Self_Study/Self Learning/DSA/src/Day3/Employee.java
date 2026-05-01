package Day3;

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
        return "ID: " + empid + ", Name: " + name + ", Salary: " + salary;
    }
}
