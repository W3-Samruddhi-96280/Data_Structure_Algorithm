package Day_01;


public class Q4 {
	public static int findFirstNonRepeating(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			int count = 0;

			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j])
					count++;
			}

			if(count == 1)
				return arr[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3,4, -1, 2, 1, 0, 4, -1, 8 };

		int result = findFirstNonRepeating(arr);

		if(result != -1)
			System.out.println("First non-repeating element : " + result);
		else
			System.out.println("No non-repeating element found");
	}
}
