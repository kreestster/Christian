package encapsulation.method.pond.shore;

import encapsulation.method.pond.goose.Goose;

public class BirdWatcher {
	public void watchFloatingBird() {
		Bird v = new Bird();
		 v.floatInWater(); // can be possible when in the same package
	}
	public void watchGoose() {
		Goose goose = new Goose();
		
		goose.floatInWater();
	}
}
