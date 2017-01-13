package test;

public class CheckString {
	public static void main(String... args){
		String toCheck = "G073000044040792";
		
		if(Character.isDigit(toCheck.charAt(0))){
			return ;
		}
		Integer x = new Integer(5);
		int y = 2;
		test(x, y);
		
		System.out.println(x + " " + y);
		
		System.out.println("test".substring(3, 1));
	}
	
public static void test(Integer i, int in){
		i = in++;;
		i++;
		System.out.println("Inner: " + i + " " + in);
		java.lang.StringBuilder sb;
	}

}
