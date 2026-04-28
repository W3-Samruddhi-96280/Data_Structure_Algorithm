package Day_04;

public class SinglyLinearLinkedList {
	// node class
	static class Node {
		// data members
		private int data;
		private Node next;

		// constructor
		public Node(int value) {
			data = value;
			next = null;
		}
	}

	// data members
	private Node head;

	// constructor
	public SinglyLinearLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int value) {
		// create new node
		Node newnode = new Node(value);

		// case 1 list empty
		if(isEmpty())
			head = newnode;

		// case 2 list not empty
		else {
			newnode.next = head;
			head = newnode;
		}
	}

	public void addLast(int value) {
		// create new node
		Node newnode = new Node(value);

		// case 1 list empty
		if(isEmpty())
			head = newnode;

		// case 2 list not empty
		else {
			Node trav = head;

			while(trav.next != null)
				trav = trav.next;

			trav.next = newnode;
		}
	}

	public void insertAfterData(int key, int value) {
		// case 1 list empty
		if(isEmpty()) {
			System.out.println("List is empty");
			return;
		}

		// case 2 list not empty
		Node trav = head;

		while(trav != null) {
			if(trav.data == key) {
				Node newnode = new Node(value);

				newnode.next = trav.next;
				trav.next = newnode;

				System.out.println(value + " inserted after " + key);
				return;
			}

			trav = trav.next;
		}

		System.out.println("Given data not found");
	}

	public void displayList() {
		// case 1 list empty
		if(isEmpty()) {
			System.out.println("List is empty");
			return;
		}

		// case 2 list not empty
		System.out.print("List : ");

		Node trav = head;

		while(trav != null) {
			System.out.print(trav.data + " ");
			trav = trav.next;
		}

		System.out.println();
	}
}
