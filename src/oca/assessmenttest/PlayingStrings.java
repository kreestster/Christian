package oca.assessmenttest;

public class PlayingStrings {
	
	private static int $;
	public static void main(String[] args){
		String s1 = "Java";
		String s2 = new String("Java");
		
		//s1 and s3 are the same object from the String pool
		String s3  = "Java";
		
		
		System.out.println(s1 == s2);
		//thus comparing s1 and s3 returns true
		System.out.println(s1 == s3);
		//Class and instance variables have default values and allow referencing
		//uninitialized local variable would give a compiler error
		System.out.println($);
		
		
	}
}
