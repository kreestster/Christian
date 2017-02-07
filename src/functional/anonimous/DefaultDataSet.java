package functional.anonimous;

public class DefaultDataSet {

	final int SIZE = 15;
	final int[] dataset = new int[SIZE];

	DefaultDataSet() {
		for (int i = 0; i < SIZE; i++) {
			dataset[i] = i;
		}
	}
	
	void printEven(){
		EvenIterator it = new EvenIterator();
		while(it.hasNext()) {
			System.out.println(it.next() + "");
		}
	}

	private class EvenIterator implements DataSetIterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return (index < SIZE - 1);
		}

		@Override
		public Integer next() {
			int response = dataset[index];
			index = index + 2;
			return response;
		}

	}
	
	public static void main(String...strings) {
		DefaultDataSet ds = new DefaultDataSet();
		ds.printEven();
	}
}

