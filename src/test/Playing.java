package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Playing {
	
	private void play1() {
		double percImpTitolo  =  0.0;
		if(percImpTitolo == 0) 
			System.out.println("1");
		
		String a  = "";
		a += 2;
		a += 'c';
		a += false;
		
		StringBuilder letters  = new StringBuilder("abcdefg");
		
		letters.substring(1, 2);
//		String d = letters.substring(6, 5);
			
		System.out.println(a);
		
		Playing.test();
	}
	
	/**
	 * 
	 */
	private void play2() {
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String a = "astring";
			Pattern p = Pattern.compile("[aeiou]");
			Matcher m  = p.matcher(a);
			int start = 0;
			if(m.find()) {
				start = m.start();
				System.out.println( start );
				System.out.println( m.end());
			}else
				System.out.println( "not found");
			

		}
		
	}
	public static void main(String...strings) {
		Playing p = new Playing();p.play2();
	}
	
	final static public void test() {
		try {
			Class t = Class.forName("test.Playing");
			Method[] methods = t.getDeclaredMethods();
			java.util.List<Method> a = Arrays.asList(methods);
			
			
			
			for(Method meth: a) System.out.println(meth.getModifiers() + " " + meth.getReturnType() + " " + meth.getName());
			\u0069\u0066\u0028\u0074\u0072\u0075\u0065\u0029
				System.out.println("got");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void method1 (String a) {
		
	}
}
