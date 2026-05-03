package Day_02;


public class ExpressionEvaluation {
	private int priority(char op) {
		if(op == '+' || op == '-')
			return 1;
		if(op == '*' || op == '/')
			return 2;
		return 0;
	}

	private int calculate(int a, int b, char op) {
		if(op == '+')
			return a + b;
		if(op == '-')
			return a - b;
		if(op == '*')
			return a * b;
		if(op == '/')
			return a / b;
		return 0;
	}

	public int evaluate(String expr) {
		int[] values = new int[expr.length()];
		char[] ops = new char[expr.length()];
		int vtop = -1;
		int otop = -1;

		for(int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);

			if(ch == ' ')
				continue;

			if(Character.isDigit(ch)) {
				int num = 0;
				while(i < expr.length() && Character.isDigit(expr.charAt(i))) {
					num = num * 10 + (expr.charAt(i) - '0');
					i++;
				}
				i--;
				values[++vtop] = num;
			}
			else if(ch == '(') {
				ops[++otop] = ch;
			}
			else if(ch == ')') {
				while(otop != -1 && ops[otop] != '(') {
					int b = values[vtop--];
					int a = values[vtop--];
					char op = ops[otop--];
					values[++vtop] = calculate(a, b, op);
				}
				otop--;
			}
			else {
				while(otop != -1 && priority(ops[otop]) >= priority(ch)) {
					int b = values[vtop--];
					int a = values[vtop--];
					char op = ops[otop--];
					values[++vtop] = calculate(a, b, op);
				}
				ops[++otop] = ch;
			}
		}

		while(otop != -1) {
			int b = values[vtop--];
			int a = values[vtop--];
			char op = ops[otop--];
			values[++vtop] = calculate(a, b, op);
		}

		return values[vtop];
	}
}
