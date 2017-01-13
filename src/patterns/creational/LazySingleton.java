package patterns.creational;

public class LazySingleton {
	private LazySingleton instance = null;
	
	public LazySingleton getLazySingleton(){
		if(instance == null)
			this.instance = new LazySingleton();
		return instance;
	}

}
