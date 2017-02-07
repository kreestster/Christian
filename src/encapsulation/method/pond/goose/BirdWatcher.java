package encapsulation.method.pond.goose;
import encapsulation.method.pond.shore.Bird;

public class BirdWatcher {
	public void watchFloatingBird() {
		Bird v = new Bird();
		// v.floatInWater(); // obviously not a subclass, not in the same package.
	}
	public void watchGoose() {
		Goose goose = new Goose();
		
		//goose.floatInWater();
	}
}
