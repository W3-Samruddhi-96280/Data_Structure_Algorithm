package Day_01;





public class Q1 {
	public static int linearSearchLastOccurence(int arr[], int key) {
		int index = -1;

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key)
				index = i;
		}

		return index;
	}

	public static void main(String[] args) {
		int arr[] = { 18, 22, 26, 44, 22, 55, 88 };
		int key = 88;

		int index = linearSearchLastOccurence(arr, key);

		if(index != -1)
			System.out.println("Last occurrence found at index : " + index);
		else
			System.out.println("Key not found");
	}
}
