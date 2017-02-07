package test;

public class CheckStatic {
	public static String STATIC1 = "STATIC1";
	
	public static void main(String...strings) {
		CheckStatic c = new CheckStatic2();
		
		System.out.println(c.STATIC1);
		c = null;
		System.out.println(c.STATIC1);
		//String statica = c.STATIC2;
	}

}
