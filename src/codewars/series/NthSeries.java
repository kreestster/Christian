package codewars.series;

/*
1 + 1/4 + 1/7 + 1/10 +
*/

public class NthSeries {
	Double calc;
	public String seriesSum(int n) {
		/* il trick sta nel partire con i = 0 
		di modo che con la prima iterazione si ottiene calc = 1
		*/
		int i = 0;
		calc = 0.0d;
		while(i < n) {
				calc = calc + (1.0 /  (1.0+ i++*3));
		}
		return String.format("%.2f", calc);
	}
	
	public static void main(String... args){
		String out = "";
		NthSeries instance = new NthSeries();
		out = instance.seriesSum(5);
		System.out.println(out);
		
		out = instance.seriesSum(9);
		System.out.println(out);

		out = instance.seriesSum(15);
		System.out.println(out);
	}
	
}