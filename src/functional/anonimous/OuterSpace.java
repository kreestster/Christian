package functional.anonimous;

import java.util.Iterator;
import java.util.ArrayList;


public class OuterSpace {
	private String outerField = "out";
	
	private class InnerSpace{
		private String innerfield1 =  "in1";
		public String innerfield2 = "in2";
		
		public String getOuterField() {
			String local = new OuterSpace().outerField;
			return local;
		}
		public class InnerSpace2{
			private String deepField1 ="ds1";
			public String deepField2 =  "ds2";
			
			public void test() {
				ArrayList<String>  as = new ArrayList<String>();
				as.add(new OuterSpace().outerField);
				as.add(new InnerSpace().innerfield1);
				as.add(new InnerSpace().innerfield2);
				as.add(new InnerSpace2().deepField1);
				as.add(new InnerSpace2().deepField2);
				Iterator<String> it = as.iterator();
				
				
			}
			
			
			
		}
	}
	
	protected class ProtectedClass {
		
	}
	
	public static void main(String...strings) {
		OuterSpace os = new OuterSpace();
		
		OuterSpace.InnerSpace is =  os.new InnerSpace();
		OuterSpace.InnerSpace.InnerSpace2 ds = is.new InnerSpace2();
		
		System.out.println(os.outerField);

//		System.out.println(is.outerField);
//		
//		
//		System.out.println(ds.outerField);
//		System.out.println(ds.outerField);

	}

}
