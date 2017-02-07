package functional.local;

public class UpdateInfo {
	void doUpdate(){
		int gone = 0;
		
		class Info{
			String name;
			String surname;
			String id;
			String info;
			String sep = " ";
			char colon = ':';
			
			Info(String name, String surname, String id, String info) throws Exception{
				
				this.name = name;
				this.surname = surname;
				this.id = id;
				this.info = info;
				if(info == null || id == null)
					throw new Exception("You can't instantiate an incomplete info. " + this.toString());
				
			}
			
			
			
			public String toString(){
				return name + sep + surname + colon + sep + info;
			}
			
			String getId() {
				return id;
			}
			
		}
		
		try {
			Info i1 = new Info("Gigi", "Sironi", "1", "Giornalista televisivo");
			Info i2 = new Info("Andrea", "Guerra", "2", "Giornalista blogger");
			Info i3 = new Info("Pippo", "Biasutti", "3", null);
			System.out.println(i1.getId() + i1.sep + i1.toString());
			System.out.println(i2.getId() + i2.sep + i2.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // doUpdate
	public static void main(String...strings) {
		UpdateInfo ui = new UpdateInfo();
		ui.doUpdate();
	}
}
