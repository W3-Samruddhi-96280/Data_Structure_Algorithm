package Day_01;
import java.util.*;

public class Q2 {

    static void linearSearch(int[] arr, int key) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == key) {
                System.out.println("Linear: Found at index " + i);
                System.out.println("Comparisons = " + count);
                return;
            }
        }
        System.out.println("Linear: Not found");
        System.out.println("Comparisons = " + count);
    }

    static void binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (arr[mid] == key) {
                System.out.println("Binary: Found at index " + mid);
                System.out.println("Comparisons = " + count);
                return;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Binary: Not found");
        System.out.println("Comparisons = " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        linearSearch(arr, key);

        Arrays.sort(arr); // required for binary search
        binarySearch(arr, key);

        sc.close();
    }
}