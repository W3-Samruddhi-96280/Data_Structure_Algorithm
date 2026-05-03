package Day_04;


public class EmployeeLinkedList {
	static class Node {
		private Employee data;
		private Node next;

		public Node(Employee emp) {
			data = emp;
			next = null;
		}
	}

	private Node head;

	public EmployeeLinkedList() {
		head = null;
	}

	public void addEmployee(Employee emp) {
		Node newnode = new Node(emp);

		if(head == null) {
			head = newnode;
			return;
		}

		Node trav = head;
		while(trav.next != null)
			trav = trav.next;

		trav.next = newnode;
	}

	public Employee searchByName(String name) {
		Node trav = head;

		while(trav != null) {
			if(trav.data.getName().equalsIgnoreCase(name))
				return trav.data;
			trav = trav.next;
		}
		return null;
	}

	public boolean deleteByEmpid(int empid) {
		if(head == null)
			return false;

		if(head.data.getEmpid() == empid) {
			head = head.next;
			return true;
		}

		Node trav = head;
		while(trav.next != null) {
			if(trav.next.data.getEmpid() == empid) {
				trav.next = trav.next.next;
				return true;
			}
			trav = trav.next;
		}
		return false;
	}

	public boolean updateSalary(int empid, double salary) {
		Node trav = head;

		while(trav != null) {
			if(trav.data.getEmpid() == empid) {
				trav.data.setSalary(salary);
				return true;
			}
			trav = trav.next;
		}
		return false;
	}

	public void displayAll() {
		Node trav = head;

		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
}
