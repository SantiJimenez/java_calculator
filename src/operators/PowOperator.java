package operators;

import java.util.List;

import calculator.Operator;

public class PowOperator extends Operator<Double>{
	
	public PowOperator(int numOfOperand) {
		super(numOfOperand);
	}

	@Override
	public Double calc(List<Double> values) {
		// TODO Auto-generated method stub
//		System.out.println("Values to operate " + values);
		return Math.pow(values.get(0), 2);
	}

}
