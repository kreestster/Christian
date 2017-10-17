package patterns.creational.abstractfactory;

public class EmberToolkit extends AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new EmberCpu();
	}

	@Override
	public Mmu createMmu() {
		return new EmberMmu();
	}

}
