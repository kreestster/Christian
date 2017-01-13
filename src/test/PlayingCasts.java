package test;

public class PlayingCasts {
	
	public class A {
		
		public final int i = 0;
		public A(){
			System.out.println("A");
		}
	}
	
	public class B extends A{
		public final int i = 1;
		public B(){
			System.out.println("B");
		}
	}
	
	public static void main(String...strings){
		PlayingCasts x = new PlayingCasts();
		Object[] obj = new Object[3];
		
		A[] outer = new A[3];
		
		outer[0] = x.new B();
		
		A anA = x.new A();
	}

}
