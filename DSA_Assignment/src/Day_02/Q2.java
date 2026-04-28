package Day_02;



public class Q2 {
	public static boolean isPalindromeUsingTwoPointer(String str) {
		int left = 0;
		int right = str.length() - 1;

		while(left < right) {
			if(str.charAt(left) != str.charAt(right))
				return false;

			left++;
			right--;
		}

		return true;
	}

	public static boolean isPalindromeUsingRecursion(String str, int left, int right) {
		if(left >= right)
			return true;

		if(str.charAt(left) != str.charAt(right))
			return false;

		return isPalindromeUsingRecursion(str, left + 1, right - 1);
	}

	public static boolean isNumberPalindrome(int num) {
		int original = num;
		int rev = 0;

		while(num != 0) {
			int digit = num % 10;
			rev = rev * 10 + digit;
			num = num / 10;
		}

		return original == rev;
	}

	public static void main(String[] args) {
		String str = "madam";
		int num = 121;

		System.out.println("Two pointer method : " + isPalindromeUsingTwoPointer(str));
		System.out.println("Recursive method : " + isPalindromeUsingRecursion(str, 0, str.length() - 1));
		System.out.println("Number reverse method : " + isNumberPalindrome(num));

		System.out.println();
		System.out.println("Complexity Analysis:");
		System.out.println("1. Reverse number and compare: Time O(d), Space O(1)");
		System.out.println("2. Convert to array/string and compare: Time O(n), Space O(n)");
		System.out.println("3. Two pointer approach: Time O(n), Space O(1)");
		System.out.println("4. Recursion approach: Time O(n), Space O(n)");
	}
}
