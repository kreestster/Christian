package patterns.creational.abstractfactory;

public class AbstractFactoryClient {
	private AbstractFactoryClient(){
		super();
	}
	
	public static void main(String[] args) throws UnknownArchitectureTypeException{
		AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
		Cpu cpu = factory.createCpu();
		
		cpu.hashCode();
		
	}

}
