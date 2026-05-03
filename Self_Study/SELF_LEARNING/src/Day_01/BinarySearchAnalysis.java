package Day_01;

public class BinarySearchAnalysis {
	private int comparisons;
	private int swaps;

	public int searchAscending(int[] arr, int key) {
		comparisons = 0;
		swaps = 0;

		int left = 0;
		int right = arr.length - 1;

		while(left <= right) {
			int mid = (left + right) / 2;
			comparisons++;

			if(arr[mid] == key)
				return mid;
			else if(key < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	public int searchDescending(int[] arr, int key) {
		comparisons = 0;
		swaps = 0;

		int left = 0;
		int right = arr.length - 1;

		while(left <= right) {
			int mid = (left + right) / 2;
			comparisons++;

			if(arr[mid] == key)
				return mid;
			else if(key > arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	public int getComparisons() {
		return comparisons;
	}

	public int getSwaps() {
		return swaps;
	}
}
