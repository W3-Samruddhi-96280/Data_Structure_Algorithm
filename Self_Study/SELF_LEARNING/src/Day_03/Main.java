package Day_03;

public class Main {
	public static void main(String[] args) {
		EmployeeLinkedList list = new EmployeeLinkedList();

		list.addEmployee(new Employee(1, "Amit", 50000));
		list.addEmployee(new Employee(2, "Rahul", 60000));
		list.addEmployee(new Employee(3, "Neha", 70000));

		System.out.println("All Employees");
		list.displayAll();

		Employee emp = list.searchByName("Rahul");
		if(emp != null)
			System.out.println("Found : " + emp);
		else
			System.out.println("Employee not found");
	}
}
