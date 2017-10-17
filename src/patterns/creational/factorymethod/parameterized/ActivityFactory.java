package patterns.creational.factorymethod.parameterized;

public abstract class ActivityFactory {

	private static MolActivity molActivity =null; 
	
	public static ActivityInterface getActivity(ActivityTypeEnum activity, SupplierTypeEnum supplier) throws Exception {

		switch (supplier) {
		case MOL:
			if(molActivity == null)
				molActivity = MolActivityFactory.getInstanceType(activity);
		default:

		}
		return null;
	}

	public void start() {
		// TODO Auto-generated method stub

	}

	public Long getLastProcessId(Long leadId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ActivityInterface getOrCreateActivity(ActivityTypeEnum activityType, SupplierTypeEnum activityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
