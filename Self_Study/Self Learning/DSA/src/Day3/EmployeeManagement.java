package Day3;

import java.util.Scanner;

public class EmployeeManagement {
    Node head = null;

    public void addEmployee(int id, String name, double salary) {
        Node newNode = new Node(new Employee(id, name, salary));
        newNode.next = head;
        head = newNode;
        System.out.println("Employee added successfully.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        EmployeeManagement list = new EmployeeManagement();
        list.addEmployee(101, "Alice", 50000);
        list.addEmployee(102, "Bob", 60000);
        list.displayAll();
    }
}
