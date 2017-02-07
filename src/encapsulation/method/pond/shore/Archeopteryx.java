package encapsulation.method.pond.shore;

public class Archeopteryx extends Bird {
	public void swim() {
		/**
		 * Birds canbe floated only from the same package
		 * */
		Bird d = new Bird();
		d.floatInWater();
		System.out.println(d.text);
	}
}
