package Day_01;


public class NthOccurrenceLinearSearch {
	public int search(int[] arr, int key, int n) {
		int count = 0;

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				count++;
				if(count == n)
					return i;
			}
		}
		return -1;
	}
}
