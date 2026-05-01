package Day2;

public class PostfixEvaluator {

    // Internal Stack Class to handle storage
    static class Stack {
        private int arr[];
        private int top, size;

        public Stack(int n) {
            size = n;
            arr = new int[size];
            top = -1;
        }

        public void push(int val) {
            if (top != size - 1) 
                arr[++top] = val;
        }

        public int pop() {
            if (top != -1) 
                return arr[top--];
            return 0;
        }
    }

    public static int evaluate(String expression) {
        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // Convert char digit to integer
                stack.push(c - '0');
            } 
            else {
                // Popping order matters: second pop is the first operand
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (c) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "23+5*"; // Logic: (2+3) * 5 = 25
        System.out.println("Expression: " + exp);
        System.out.println("Postfix Evaluation Result: " + evaluate(exp));
    }
}
