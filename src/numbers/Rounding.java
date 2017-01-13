package numbers;

import java.math.BigDecimal;

public class Rounding {

	public static void main(String[] args) {
		double premio = 12.145;
		double mathRintPremio = Math.rint(premio*100)/100;
		
		BigDecimal b1 = BigDecimal.valueOf(premio).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal b2 = BigDecimal.valueOf(premio).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal b3 = BigDecimal.valueOf(premio).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		BigDecimal solution = BigDecimal.valueOf(mathRintPremio).setScale(2);

		System.out.println("Math.rint:      " +mathRintPremio);
		System.out.println("ROUND_HALF_UP   " + b1);
		System.out.println("ROUND_HALF_DOWN " + b2);
		System.out.println("ROUND_HALF_EVEN " + b3);
		System.out.println("BigDecimal      " + solution);
		
		
	}

}
