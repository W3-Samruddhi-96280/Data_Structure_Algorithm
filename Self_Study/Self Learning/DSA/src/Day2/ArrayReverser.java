package Day2;

import java.util.Arrays;

public class ArrayReverser {

    // Helper Method to reverse the array
    public static void reverseArray(int[] arr) {
        int n = arr.length;
        // Create a simple stack specifically for this operation
        int[] stackArr = new int[n];
        int top = -1;

        // Step 1: Push all elements onto the stack
        for (int i = 0; i < n; i++) {
            stackArr[++top] = arr[i];
        }

        // Step 2: Pop elements back into the array
        for (int i = 0; i < n; i++) {
            arr[i] = stackArr[top--];
        }
    }

    public static void main(String[] args) {
        // Sample array
        int[] data = {11, 22, 33, 44, 55};
        
        System.out.println("Before Reverse: " + Arrays.toString(data));
        
        reverseArray(data);
        
        System.out.println("After Reverse: " + Arrays.toString(data));
    }
}
