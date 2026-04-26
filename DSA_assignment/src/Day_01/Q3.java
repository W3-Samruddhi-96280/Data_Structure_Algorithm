package Day_01;



import java.util.*;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee arr[] = new Employee[n];

        // 📥 Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter id: ");
            int id = sc.nextInt();

            System.out.print("Enter name: ");
            String name = sc.next();

            arr[i] = new Employee(id, name);
        }

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 Search by ID");
            System.out.println("2 Search by Name");
            System.out.println("3 Display");
            System.out.println("4 Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();

                    for (Employee e : arr) {
                        if (e.id == sid) {
                            System.out.println("Found: " + e.id + " " + e.name);
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String sname = sc.next();

                    for (Employee e : arr) {
                        if (e.name.equalsIgnoreCase(sname)) {
                            System.out.println("Found: " + e.id + " " + e.name);
                            break;
                        }
                    }
                    break;

                case 3:
                    for (Employee e : arr) {
                        System.out.println(e.id + " " + e.name);
                    }
                    break;

            }

        } while (choice != 4);

        sc.close();
    }
}