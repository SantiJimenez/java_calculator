package calculator;

import java.util.HashMap;
import java.util.Map;

import interfaces.iToken;
import operators.AddOperator;
import operators.DivideOperator;
import operators.MultiplyOperator;
import operators.PowOperator;
import operators.SubtractOperator;

public class RPNCalculator extends Calculator<Double> {

	@Override
	protected iToken<Double> parseToken(String token) {
		// TODO Auto-generated method stub
		switch(token) {
        case "plus" :
            return new AddOperator(2);
        case "minus" :
            return new SubtractOperator(2);
        case "into" :
            return new MultiplyOperator(2);
        case "over" :
            return new DivideOperator(2);
        case "^^":
        	return new PowOperator(1);
        default :
            try {
                return new Operand<>(Double.parseDouble(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Token found: " + token, e);
            }
		} 
	}

}
