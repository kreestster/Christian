package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckArrays {

	private static void testArrayList() {
		Integer _7 = new Integer(7);
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add(_7.toString());
		
	}
	public static void main(String... strings) {
		testArrayList();
		// this declaration defines a reference to array object of type int.
		int[] good;

		// this declaration is good enough.
		//initialization allows assignments of Arrays constants - anonymous arrays
		int odd[] = {1, 2, 3};

		// this is misleading declaration. The compiler starts with an int named
		// awful[]
		// -> then it find it's an array of int because of the []
		// next it find a simple int variable named less.

		int awful[], less;

		good = new int[3];
		
		good = new int[] { 1, 2, 3 };
		
		int [][]bad = new int[2][]; 
		
		//this is not permitted since good has been already initialized
		//good = {1, 2, 3};
		
		
		//Objects type arrays
		
		String[] string1 = {"alpha", "omega", "lambda"};
		
		
		//this will write somthing like [Ljava.lang.String;@140bc7c1
		//[L this means array
		//then is specified array type
		//at last its hashcode
		System.out.println(string1.toString());
		
		
		//since java 5
		String out1 = java.util.Arrays.toString(string1);
		
		System.out.println(out1);
		
		//Sorting
		java.util.Arrays.sort(string1);

		out1 = java.util.Arrays.toString(string1);
		
		System.out.println(out1);
		/* output at this point is
		 * [Ljava.lang.String;@15db9742
		 * [alpha, omega, lambda]
		 * */
		
		//Casting arrays
		
		//widening casts doesn't need an explicit cast
		Object[] obj = string1;
		
		//intentional narrowing to a potentially runtime error
		//StringBuilder is different type than String. But Compiler does not complain with this cast.
		//It figures out that StringBuilder is good for Object but arrays is actually of type String.
		//Youìll get a runtime error ArrayStoreException
		//obj[0] = new StringBuilder();
		
		ArrayList al = new ArrayList();
		
		al.add("some");
		al.add(Boolean.TRUE);
		al.add(1);
		
		System.out.println(al.toString());
		
		//method parse<primitive_type> returns a primitive
		int intValue = Integer.parseInt("1");
		
		Integer wrapperValue = Integer.valueOf("1");
		
		//No similar parse/valueof in Character class for convertion
		//this only method returns char wrapped
		Character c  = Character.valueOf('c');
		
		//AutoBoxing
		
		java.util.List<Double> var  =new ArrayList<Double>();
		
		var.add(50.0); //autoboxing
		var.add(new Double(45.5)); //explicit type
		var.remove(50.0); //autoboxing
		
		
		double out = var.get(0); //unboxing
		
		//BE CAREFUL:  when ArrayList-ing with Integer
		
		java.util.List<Integer> var2 = new ArrayList<>();
		
		var2.add(1); // [1]
		var2.add(2); // [1, 2]
		var2.remove(1);//this parameter is assumed to be an array index NOT the value itself!!!1
		
		var2.remove(new Integer(1)); // this would do the trick. Looks for what is equals to parameter value. if found remove.
		
		//at this point var2 has to be empty
		
		System.out.println("var2 size: " +var2.size());
		
		//return a new array of type Object with elements of ArrayList var2
		Object[] response1 = var2.toArray();
		
		//initialize a new array with effective size of var2 if passed in array doesn't fit. Advantage: is typed.
		Integer[] response2  = var2.toArray(new Integer[0]);
		
		
		String[] ar1 = new String[] {"one","two"};
		
		//creating a List starting from an existing array makes the backed list is linked with the original array.
		java.util.List<String> on = Arrays.asList(ar1); // returns a fixed size list. No remove op is allowed(exception)
		
		//changing value from backed list ..
		on.set(0, "changedValueFromList");
		
		// reflect changes in original arrays
		for(String b: ar1) System.out.println("value: " + b);
		
		//UnsopportedOperationException
		//on.remove(1);
		
		java.util.Collections.sort(on, Collections.reverseOrder());
		
		for(String b: ar1) System.out.println("value: " + b);
		
		
	}
}
