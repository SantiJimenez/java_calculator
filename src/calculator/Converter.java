package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Converter {
	
	private static Map<String, Integer> PRECEDENCE_OPERATORS = new HashMap<>();
	private Stack<String> expressionStack;
	private Stack<String> operatorsStack;
	
	public Converter() {
		this.expressionStack = new Stack<>();
		this.operatorsStack = new Stack<>();
		loadPRECEDENCE_OPERATORS();
	}
	
	private void loadPRECEDENCE_OPERATORS() {
		PRECEDENCE_OPERATORS.put("plus", 1);
		PRECEDENCE_OPERATORS.put("minus", 1);
		PRECEDENCE_OPERATORS.put("into", 2);
		PRECEDENCE_OPERATORS.put("over", 2);
		PRECEDENCE_OPERATORS.put("^^", 3);
	}
	
	private boolean isNumber(String n) {
		try {
			double number = Double.parseDouble(n);
			return true;
		} catch (NumberFormatException e) {
//			System.out.println("Invalid Token found: " + n);
			return false;
		}
	}
	
	public Stack<String> infixToPostfix(String expression) {
		String[] exp = expression.split(" ");
		for(String token : exp) {
//			System.out.println("token: " + token);
			if (this.isNumber(token)) {
				expressionStack.push(token);
//				System.out.println("1. pushing on exp " + token);
			} else if (token == "(") {
				operatorsStack.push(token);
//				System.out.println("1. pushing on ops " + token);
			} else if (token == ")") {
				String tailElement = operatorsStack.pop();
				while (tailElement != "(") {
					expressionStack.push(tailElement);
					tailElement = operatorsStack.pop();
				}
			} else {
				try {
					if (PRECEDENCE_OPERATORS.get(token) != null) {
//						System.out.println(".....In else try");
//						operatorsStack.push(token);
//						System.out.println("Operators is empty " + operatorsStack.empty());
//						System.out.println("Operators " + operatorsStack);
//						System.out.println("Precedence " + PRECEDENCE_OPERATORS.get(token));
//						System.out.println("Last operator stack " + operatorsStack.lastElement());
//						System.out.println("Precedence last operator stack " + PRECEDENCE_OPERATORS.get(operatorsStack.lastElement()));
//						System.out.println("Precedence current token " + PRECEDENCE_OPERATORS.get(token));
						while (!operatorsStack.empty() && PRECEDENCE_OPERATORS.get(operatorsStack.lastElement()) >= PRECEDENCE_OPERATORS.get(token)) {
							expressionStack.push(operatorsStack.pop());
//							System.out.println("2. pushing on exp " + token);
						}
						operatorsStack.push(token);
//						System.out.println("2. pushing on ops " + token);
					}
				} catch (Exception e) {
//					return null;
				}
			}
		}
		
		while (!operatorsStack.empty()) {
			expressionStack.push(operatorsStack.pop());
//			System.out.println("pushing on ops to exp final");
		}
		
		return expressionStack;
	}
}
