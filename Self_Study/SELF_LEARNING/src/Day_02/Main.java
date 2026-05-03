package Day_02;


public class Main {
	public static void main(String[] args) {
		ComplexityTable table = new ComplexityTable();
		table.display();

		StackUsingArray stack = new StackUsingArray(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.print("Stack : ");
		stack.display();

		QueueUsingArray queue = new QueueUsingArray(5);
		queue.push(10);
		queue.push(20);
		queue.push(30);
		System.out.print("Queue : ");
		queue.display();

		CircularQueue cq = new CircularQueue(5);
		cq.push(10);
		cq.push(20);
		cq.push(30);
		cq.pop();
		cq.push(40);
		System.out.print("Circular Queue : ");
		cq.display();

		int[] arr = {1, 2, 3, 4, 5};
		ReverseArrayUsingStack reverse = new ReverseArrayUsingStack();
		reverse.reverse(arr);
		System.out.print("Reverse Array : ");
		for(int value : arr)
			System.out.print(value + " ");
		System.out.println();

		ExpressionEvaluation ee = new ExpressionEvaluation();
		System.out.println("Expression Result : " + ee.evaluate("10 + 2 * 6"));
	}
}
