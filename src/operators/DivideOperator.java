package operators;

import java.util.List;

import calculator.Operator;

public class DivideOperator extends Operator<Double> {

	public DivideOperator(int numOfOperand) {
		super(numOfOperand);
	}

	@Override
	public Double calc(List<Double> values) {
		// TODO Auto-generated method stub
		
		double result = values.get(0);
//		System.out.println("Values to operate " + values);
		for (int i = 1; i < values.size(); i++) {
			result /= values.get(i);
		}
		return result;
	}
	
	
}
