package Day1;

import java.util.Scanner;

public class BinarySearchMain {
	
	public static int binarySearchDescending(int arr[], int n, int key) {
		int left = 0, right = n - 1, mid;
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(key == arr[mid])
				return mid;
			
			if(key < arr[mid])
				left = mid + 1; // Key is smaller, look to the right in descending
			else
				right = mid - 1; // Key is larger, look to the left in descending
		}
		return -1;	
	}

	public static void main(String[] args) {
		int arr[] = {99, 88, 77, 66, 55, 44, 33, 22, 11};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the key to search:");
		int key = sc.nextInt();
		int index = binarySearchDescending(arr, arr.length, key);
		
		if(index == -1)
			System.out.println("Key not found");
		else
			System.out.println("Key found at index: " + index);
	}
}
