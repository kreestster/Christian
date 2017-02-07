package test;

import java.util.Arrays;

public class TestRegEx {

	public static void main(String...strings) {
		String[] ar = {"A134134123","R123412341324", "AT123f34RRR","123QE123413QW"};
		System.out.println(Arrays.deepToString(ar));
		for(String s: ar) {
			String[] ar1 = null;
			String[] ar2 = null;
			ar1 = s.split("[0-9]+");
			ar2 = s.split("^[^0-9]+", 2);
			if(ar1 != null) {
				System.out.print("Array occurrence: ");
				System.out.println(Arrays.deepToString(ar1));
			}
		}
	}
}
