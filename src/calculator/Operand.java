package calculator;

import java.util.Stack;

import interfaces.iToken;

public class Operand<T> implements iToken<T>{
	private final T val; 
	
	public Operand(T val) {
		this.val = val;
	}

	@Override
	public void process(Stack<T> stack) {
		// TODO Auto-generated method stub
		stack.push(val);
	}
}
