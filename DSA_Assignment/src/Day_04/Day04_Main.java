package Day_04;

import java.util.Scanner;

public class Day04_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SinglyLinearLinkedList list = new SinglyLinearLinkedList();

		int choice;

		do {
			System.out.println("0. Exit");
			System.out.println("1. Add First");
			System.out.println("2. Add Last");
			System.out.println("3. Insert After Data");
			System.out.println("4. Display List");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();

			switch(choice) {
			case 1:
				System.out.print("Enter data : ");
				list.addFirst(sc.nextInt());
				break;

			case 2:
				System.out.print("Enter data : ");
				list.addLast(sc.nextInt());
				break;

			case 3:
				System.out.print("Enter given data : ");
				int key = sc.nextInt();

				System.out.print("Enter new data : ");
				int value = sc.nextInt();

				list.insertAfterData(key, value);
				break;

			case 4:
				list.displayList();
				break;
			}

		} while(choice != 0);

		sc.close();
	}
}
