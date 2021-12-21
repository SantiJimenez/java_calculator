package calculator;

import java.util.*;
import interfaces.*;

public abstract class Operator<T> implements iToken<T> {

	private final int numOfOperand;
	
	
	public Operator(int numOfOperand) {
		this.numOfOperand = numOfOperand;
	}


	@Override
	public void process(Stack<T> stack) {
		// TODO Auto-generated method stub
		if(stack == null) {
			System.out.println("Error: Empty stack");
		}
		
		else if(stack.size() < numOfOperand) {
			System.out.println("Error: Insufficient elements in the stack to calculte");
//            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        List<T> valList = new ArrayList<>(numOfOperand);
//        System.out.println("Stack to operate " + stack);
        for(int i = 0; i < numOfOperand; i++) {
            valList.add(0, stack.pop());
//            System.out.println("ValList " + valList);
        }
        stack.push(calc(valList));
	}
	
	public abstract T calc(List<T> values);
	
}
