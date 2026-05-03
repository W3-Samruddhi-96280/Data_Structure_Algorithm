package Day_02;


public class ReverseArrayUsingStack {
	public void reverse(int[] arr) {
		StackUsingArray stack = new StackUsingArray(arr.length);

		for(int i = 0; i < arr.length; i++)
			stack.push(arr[i]);

		for(int i = 0; i < arr.length; i++)
			arr[i] = stack.pop();
	}
}
