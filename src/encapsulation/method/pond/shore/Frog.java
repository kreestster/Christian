package encapsulation.method.pond.shore;

public class Frog {
	public void mindOverWhelming() {
		/**
		 * Birds canbe floated only from the same package even from a Frog
		 * whose not extending Bird class
		 * 
		 * */
		
		Bird d = new Bird();
		d.floatInWater();
		System.out.println(d.text);
		
	}
}
