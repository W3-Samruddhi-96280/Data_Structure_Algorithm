package Day9;

public class FibonacciComparison {

    // Technique 1: Brute Force Recursion - O(2^n)
    public static long fibBruteForce(int n) {
        if (n <= 1) return n;
        return fibBruteForce(n - 1) + fibBruteForce(n - 2);
    }

    // Technique 2: Dynamic Programming (Memoization) - O(n)
    public static long fibDP(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n]; // Return cached value
        
        memo[n] = fibDP(n - 1, memo) + fibDP(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40; // Try 40-45 to see the massive time difference
        
        // Test Brute Force
        long start = System.currentTimeMillis();
        long res1 = fibBruteForce(n);
        long end = System.currentTimeMillis();
        System.out.println("Brute Force Result: " + res1 + " | Time: " + (end - start) + "ms");

        // Test DP
        start = System.currentTimeMillis();
        long[] memo = new long[n + 1];
        long res2 = fibDP(n, memo);
        end = System.currentTimeMillis();
        System.out.println("DP Result: " + res2 + " | Time: " + (end - start) + "ms");
    }
}
