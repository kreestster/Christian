package test;

public class CheckNumbers {
	public static void main(String...args){
		//some variable definition
		//short x = 1;
		
		//literal 13 is created as int and promoted to float
		float y = 13;
		
		//literal 12.0 is created as double. compiler need a cast to float. 
		//float n = 12.0;
		int x = 3;
		if (x==5) {}
		else if (x<9)
		{
		  System.out.println("x is less than 9");
		}
		else if (x<6)
		{
		  System.out.println("x is less than 6");
		}
		else
		{
		  System.out.println("else");
		}
		double z = 22;
		
		float m = 1f * (short)0.0;
		
		// short x is first promoted to int before expression evaluation. Then all is promoted to wider format. 
		Number result = x*y/z;
		
		int i = -5;
		int r = 0;
		
		for(r = 1; r < 6; r++){
			System.out.println(i + " % " + r + " = " + (i % r));
		}
		
	}

}
