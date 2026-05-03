package Day_01;

public class LinearSearchAnalysis {
	private int comparisons;
	private int swaps;

	public int search(int[] arr, int key) {
		comparisons = 0;
		swaps = 0;

		for(int i = 0; i < arr.length; i++) {
			comparisons++;
			if(arr[i] == key)
				return i;
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
