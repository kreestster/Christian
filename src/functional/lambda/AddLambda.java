package functional.lambda;

import java.util.function.BinaryOperator;

public class AddLambda {
	public static void main(String...strings) {
		
		
		double result = operation((Double a, Double b)-> a + b, 1.0, 2.0);
		
		System.out.println(result);
	}
	
	private static Double operation(BinaryOperator<Double> p,Double a, Double b) {
		Double result = new Double(0);
			result =p.apply(a, b);
		return result;
	}
}
