package Day_01;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        int pos = -1;

        // linear search
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                pos = i;
            }
        }

        if (pos == -1)
            System.out.println("Not found");
        else
            System.out.println("Last index = " + pos);

        sc.close();
    }
}