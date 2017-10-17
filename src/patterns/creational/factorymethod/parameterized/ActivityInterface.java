package patterns.creational.factorymethod.parameterized;

public interface ActivityInterface {
	
	public void start();
	
	public Long getLastProcessId(Long leadId);
	
	public ActivityInterface getOrCreateActivity(ActivityTypeEnum activityType, SupplierTypeEnum activityId);
	
	public ActivityInterface 
	
}
