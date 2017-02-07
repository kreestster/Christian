package encapsulation.method.pond.goose;

import encapsulation.method.pond.shore.Bird;

public class Goose extends Bird {

	/*
	 * super class protected members here accessed directly from an extending subclass 
	 * OK
	 * */
	public void swim() {
		floatInWater();
		System.out.println(text);
	}
	
	public void swimAGenericBird() {
		Bird b = new Bird();
		
		//b.floatInWater(); // method is not visible here 'cause Bird is not a subclass of Bird itself
		//b.text; // same for protected field
		
	}
	
	public void helpOtherGooseSwim() {
		Goose goose = new Goose();
		goose.floatInWater();
		System.out.println(goose.text);
		
	}

}
