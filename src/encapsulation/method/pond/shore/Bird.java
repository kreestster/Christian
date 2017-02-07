package encapsulation.method.pond.shore;

/**
 * This class is to test protected access modifier.
 * protected = default (same package) + subclasses.
 * 
 * Any protected members in Declared class can be accessed directly  from Outside class IIF
 * 
 *  Outside extends Declared OR Outside and Declared share the same package.
 *  Only accessible from instance of Outside or subclasses of Outside
 *  
 *  
 *  Tricky situations...
 *  1. You want to access protected members in Fail class (outside package and not subclass)
 *  through an instance of an allowed class (valid subclass or same package)
 *  
 *  Fail class is not in the same package of Declared and not extending it directly.
 *  
 *  2. You want to access protected members in OutsideSubclassNotSamePackage using an instance of
 *  Declared.
 *  
 *  As its name says you are not in the same package and trying to use an instance of 
 *  Declared class itself wich is not a subclass of Declared.
 *  
 *  3. You want to access protected members 
 *   
 * */
public class Bird {
	
	protected String text = "floating";
	
	protected void floatInWater() {
		System.out.println(text);
	}

}
