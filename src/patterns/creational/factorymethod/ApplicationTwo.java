package patterns.creational.factorymethod;

public class ApplicationTwo implements Framework {

	@Override
	public Product makeProduct() {
		return new ProductTwo();
	}

}
