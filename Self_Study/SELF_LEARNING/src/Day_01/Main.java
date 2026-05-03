package Day_01;


public class Main {
	public static void main(String[] args) {
		int[] arr1 = {10, 20, 30, 40, 50};
		int[] arr2 = {90, 70, 50, 30, 10};
		int[] arr3 = {5, 10, 5, 20, 5, 30};

		LinearSearchAnalysis ls = new LinearSearchAnalysis();
		int index1 = ls.search(arr1, 30);
		System.out.println("Linear Search Index : " + index1);
		System.out.println("Linear Search Comparisons : " + ls.getComparisons());
		System.out.println("Linear Search Swaps : " + ls.getSwaps());

		BinarySearchAnalysis bs = new BinarySearchAnalysis();
		int index2 = bs.searchAscending(arr1, 40);
		System.out.println("Binary Search Ascending Index : " + index2);
		System.out.println("Binary Search Ascending Comparisons : " + bs.getComparisons());
		System.out.println("Binary Search Ascending Swaps : " + bs.getSwaps());

		int index3 = bs.searchDescending(arr2, 50);
		System.out.println("Binary Search Descending Index : " + index3);
		System.out.println("Binary Search Descending Comparisons : " + bs.getComparisons());
		System.out.println("Binary Search Descending Swaps : " + bs.getSwaps());

		NthOccurrenceLinearSearch ns = new NthOccurrenceLinearSearch();
		System.out.println("3rd Occurrence Index : " + ns.search(arr3, 5, 3));
	}
}
