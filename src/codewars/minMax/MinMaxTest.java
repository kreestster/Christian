package codewars.minMax;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import org.junit.Test;

public class MinMaxTest {
	public static void main(String... args) {
		long number = 123445;
		List<String> a = Arrays.asList( String.valueOf(number).split(""));
		Collections.reverse(a);
		
		Integer[] out = a.toArray(new Integer[a.size()]);
		
	}
}
