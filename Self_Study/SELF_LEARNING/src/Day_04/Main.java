package Day_04;

public class Main {
	public static void main(String[] args) {
		EmployeeLinkedList list = new EmployeeLinkedList();

		list.addEmployee(new Employee(1, "Amit", 50000));
		list.addEmployee(new Employee(2, "Rahul", 60000));
		list.addEmployee(new Employee(3, "Neha", 70000));

		System.out.println("Before Update");
		list.displayAll();

		list.updateSalary(2, 75000);
		list.deleteByEmpid(1);

		System.out.println("After Update And Delete");
		list.displayAll();
	}
}
