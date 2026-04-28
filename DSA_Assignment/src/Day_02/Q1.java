package Day_02;


public class Q1{
	public static void insertionSortDescending(int arr[]) {
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			while(j >= 0 && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;
		}
	}

	public static void displayArray(int arr[]) {
		System.out.print("Array : ");

		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 55, 44, 22, 66, 11, 33 };

		System.out.println("Before sorting");
		displayArray(arr);

		insertionSortDescending(arr);

		System.out.println("After sorting in descending order");
		displayArray(arr);
	}
}
