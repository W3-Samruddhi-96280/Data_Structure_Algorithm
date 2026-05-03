package Day_02;

public class QueueUsingArray {
	private int[] arr;
	private int front;
	private int rear;

	public QueueUsingArray(int size) {
		arr = new int[size];
		front = 0;
		rear = -1;
	}

	public boolean isEmpty() {
		return rear < front;
	}

	public boolean isFull() {
		return rear == arr.length - 1;
	}

	public void push(int value) {
		if(isFull())
			return;
		rear++;
		arr[rear] = value;
	}

	public int pop() {
		if(isEmpty())
			return -1;
		int value = arr[front];
		front++;
		return value;
	}

	public int peek() {
		if(isEmpty())
			return -1;
		return arr[front];
	}

	public void display() {
		for(int i = front; i <= rear; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
