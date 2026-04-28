package Day_01;



public class Q2 {
	public static int linearSearch(int arr[], int key) {
		int comparisons = 0;

		for(int i = 0; i < arr.length; i++) {
			comparisons++;

			if(arr[i] == key) {
				System.out.println("Key found at index : " + i);
				return comparisons;
			}
		}

		System.out.println("Key not found");
		return comparisons;
	}

	public static int binarySearch(int arr[], int key) {
		int left = 0;
		int right = arr.length - 1;
		int comparisons = 0;

		while(left <= right) {
			int mid = (left + right) / 2;

			comparisons++;

			if(key == arr[mid]) {
				System.out.println("Key found at index : " + mid);
				return comparisons;
			}
			else if(key < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}

		System.out.println("Key not found");
		return comparisons;
	}

	public static void main(String[] args) {
		int arr[] = { 11, 28, 33, 44, 55, 66, 88 };
		int key = 88;

		int linearComparisons = linearSearch(arr, key);
		System.out.println("Linear Search Comparisons : " + linearComparisons);

		int binaryComparisons = binarySearch(arr, key);
		System.out.println("Binary Search Comparisons : " + binaryComparisons);
	}
}
