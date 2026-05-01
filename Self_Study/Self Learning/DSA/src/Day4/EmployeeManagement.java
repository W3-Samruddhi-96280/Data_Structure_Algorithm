package Day4;

import java.util.Scanner;

public class EmployeeManagement {
    private Node head = null;

    // Day 3: Add employee at the beginning
    public void addEmployee(int id, String name, double salary) {
        Node newNode = new Node(new Employee(id, name, salary));
        newNode.next = head;
        head = newNode;
        System.out.println("Employee added.");
    }

    // Day 3: Display all employees
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

    // Day 3: Search employee by name
    public void searchByName(String name) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.data.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.data);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Employee not found with name: " + name);
    }

    // Day 4: Delete employee by empid
    public void deleteEmployee(int empid) {
        if (head == null) return;

        if (head.data.empid == empid) {
            head = head.next;
            System.out.println("Employee deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data.empid != empid) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Employee deleted.");
        } else {
            System.out.println("ID not found.");
        }
    }

    // Day 4: Update salary
    public void updateSalary(int empid, double newSalary) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.empid == empid) {
                temp.data.salary = newSalary;
                System.out.println("Salary updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagement list = new EmployeeManagement();
        int choice;

        do {
            System.out.println("\n1. Add 2. Display 3. Search 4. Delete 5. Update Salary 0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID, Name, Salary: ");
                    list.addEmployee(sc.nextInt(), sc.next(), sc.nextDouble());
                    break;
                case 2:
                    list.displayAll();
                    break;
                case 3:
                    System.out.print("Name: ");
                    list.searchByName(sc.next());
                    break;
                case 4:
                    System.out.print("ID to delete: ");
                    list.deleteEmployee(sc.nextInt());
                    break;
                case 5:
                    System.out.print("ID and New Salary: ");
                    list.updateSalary(sc.nextInt(), sc.nextDouble());
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}
