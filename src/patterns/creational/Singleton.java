package patterns.creational;

public class Singleton {
	private Singleton instance = new Singleton();
	
	public Singleton getInstance(){
		return instance;
	}

}
