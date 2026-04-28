package Day_01;


import java.util.Scanner;

class Employee {
	// data members
	private int empid;
	private String name;
	private double salary;

	// constructor
	public Employee() {
	}

	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public String getName() {
		return name;
	}

	public void displayEmployee() {
		System.out.println("Empid : " + empid);
		System.out.println("Name : " + name);
		System.out.println("Salary : " + salary);
	}
}

public class Q3 {
	public static int searchByEmpid(Employee arr[], int empid) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getEmpid() == empid)
				return i;
		}

		return -1;
	}

	public static int searchByName(Employee arr[], String name) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getName().equals(name))
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Employee arr[] = new Employee[5];

		arr[0] = new Employee(1, "A", 50000);
		arr[1] = new Employee(2, "B", 60000);
		arr[2] = new Employee(3, "C", 55000);
		arr[3] = new Employee(4, "D", 70000);
		arr[4] = new Employee(5, "D", 65000);

		System.out.print("Enter empid to search : ");
		int empid = sc.nextInt();

		int index = searchByEmpid(arr, empid);

		if(index != -1)
			arr[index].displayEmployee();
		else
			System.out.println("Employee not found by empid");

		System.out.print("Enter name to search : ");
		String name = sc.next();

		index = searchByName(arr, name);

		if(index != -1)
			arr[index].displayEmployee();
		else
			System.out.println("Employee not found by name");

		sc.close();
	}
}
