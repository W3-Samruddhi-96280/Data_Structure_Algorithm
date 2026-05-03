package Day_03;


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

	public void displayAll() {
		Node trav = head;

		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
}
