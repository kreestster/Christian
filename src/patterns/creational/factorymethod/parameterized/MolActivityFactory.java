package patterns.creational.factorymethod.parameterized;

public class MolActivityFactory extends ActivityFactory {

	public static MolActivity getInstanceType(ActivityTypeEnum activity) throws Exception{
		switch(activity){
		case IDENTIFICATION:
			return new MolActivity();
		case CREDIT_INQUIRY:
			return new MolActivity();
			default:
				throw new Exception();
		}
	}
	
}
