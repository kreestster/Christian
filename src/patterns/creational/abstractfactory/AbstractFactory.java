package patterns.creational.abstractfactory;

// clean way
public abstract class AbstractFactory {

	private static EmberToolkit emberToolkit = null;
	private static EnginolaToolkit enginolaToolkit = null;
	
	static AbstractFactory getFactory(Architecture arch) throws UnknownArchitectureTypeException{
		switch(arch){
		case ENGINOLA:
			if(enginolaToolkit == null)
				enginolaToolkit = new EnginolaToolkit();
			return enginolaToolkit;
		case EMBER:
			if(emberToolkit == null)
				emberToolkit = new EmberToolkit();
			return emberToolkit;
		default:
			throw new UnknownArchitectureTypeException("Unknown Type");
		}
		
	}
	
	public abstract Cpu createCpu();
	
	public abstract Mmu createMmu();
}
