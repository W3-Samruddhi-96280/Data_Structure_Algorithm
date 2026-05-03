package Day_02;

public class CircularQueue {
	private int[] arr;
	private int front;
	private int rear;
	private int count;

	public CircularQueue(int size) {
		arr = new int[size];
		front = 0;
		rear = -1;
		count = 0;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == arr.length;
	}

	public void push(int value) {
		if(isFull())
			return;
		rear = (rear + 1) % arr.length;
		arr[rear] = value;
		count++;
	}

	public int pop() {
		if(isEmpty())
			return -1;
		int value = arr[front];
		front = (front + 1) % arr.length;
		count--;
		return value;
	}

	public int peek() {
		if(isEmpty())
			return -1;
		return arr[front];
	}

	public void display() {
		for(int i = 0; i < count; i++) {
			int index = (front + i) % arr.length;
			System.out.print(arr[index] + " ");
		}
		System.out.println();
	}
}
