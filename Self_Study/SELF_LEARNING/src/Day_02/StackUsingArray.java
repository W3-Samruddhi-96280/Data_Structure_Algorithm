package Day_02;

public class StackUsingArray {
	private int[] arr;
	private int top;

	public StackUsingArray(int size) {
		arr = new int[size];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public void push(int value) {
		if(isFull())
			return;
		top++;
		arr[top] = value;
	}

	public int pop() {
		if(isEmpty())
			return -1;
		int value = arr[top];
		top--;
		return value;
	}

	public int peek() {
		if(isEmpty())
			return -1;
		return arr[top];
	}

	public void display() {
		for(int i = top; i >= 0; i--)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
