package patterns.creational.abstractfactory;

public class EnginolaToolkit extends AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new EnginolaCpu();
	}

	@Override
	public Mmu createMmu() {
		return new EnginolaMmu();
	}

}
