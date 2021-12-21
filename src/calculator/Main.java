package calculator;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String rpn = "48 36 plus 8 4 over 2 into minus 2 ^^ plus";
		String rpn = "48 plus -36 plus ( ( 8 over 4 ) into 2 ) plus 2 ^^";
		Converter converter = new Converter();
		Stack<String> expression = converter.infixToPostfix(rpn);
        System.out.println("Expression converted: " + expression);
        RPNCalculator calculator = new RPNCalculator();
        System.out.println("Result: " + calculator.evaluate(expression));
	}

}
