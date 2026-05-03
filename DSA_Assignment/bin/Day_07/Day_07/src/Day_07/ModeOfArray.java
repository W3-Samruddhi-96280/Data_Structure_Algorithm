package Day_07;


import java.util.*;

public class ModeOfArray {

    public static int findMode(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int mode = arr[0];
        int maxCount = 0;

        // Find element with max frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        return mode;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2, 5};

        int result = findMode(arr);
        System.out.println("Mode = " + result);
    }
}
