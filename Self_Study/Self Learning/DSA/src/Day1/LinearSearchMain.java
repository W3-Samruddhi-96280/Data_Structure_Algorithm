package Day1;

import java.util.Scanner;

public class LinearSearchMain {

	public static void main(String[] args) {
		
		int arr[] = {33, 55, 88, 33, 44, 33, 66, 22, 99};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter key to search:");
		int key = sc.nextInt();
		
		System.out.println("Enter the occurrence (n):");
		int n = sc.nextInt();
		
		int index = findNthOccurrence(arr, key, n);
		
		if(index == -1)
			System.out.println("Occurrence not found");
		else
			System.out.println("Occurrence " + n + " found at index: " + index);
	}

	public static int findNthOccurrence(int[] arr, int key, int n) {
		int count = 0; 
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++; 
				if (count == n) { 
					return i;
				}
			}
		}
		return -1;
	}
}
