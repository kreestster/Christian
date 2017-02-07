package functional.sam;

public class UsingSam  {

	public Sam getImpl() {
		Sam result = new Sam() {
			@Override public int sum(int a, int b){
				return a + b;
			}
		};
		return result;
	}
	public static void main(String...strings) {
		UsingSam q = new UsingSam();
		int result = q.getImpl().sum(1, 1);
		System.out.println(result);
	}
}
