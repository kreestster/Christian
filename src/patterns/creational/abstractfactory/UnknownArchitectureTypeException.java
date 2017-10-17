package patterns.creational.abstractfactory;

public class UnknownArchitectureTypeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -827191616464304655L;

	UnknownArchitectureTypeException(String description){
		super(description);
	}
}
