package algo;

import java.util.List;
import java.util.Iterator;

public class Ordering {

	private List<Comparable> naturalMergeSort(int start, int end, List<Comparable> partition) {
		//check natural ordering 
		List<Comparable> leftOrdered;
		List<Comparable> rightOrdered; 
		if(isOrdered(partition)) 
			return partition;
		if(start < end -1) {
			leftOrdered = naturalMergeSort(start, Math.floorDiv(end, 2), partition );
			rightOrdered = naturalMergeSort(Math.floorDiv(end, 2) +1,end, partition );
		}
//		if()
		return null;
	}
	private boolean isOrdered(List<Comparable> partition) {
		boolean ordered = true;
		Iterator<Comparable> it  = partition.iterator();
		Comparable c1 = null;
		if(it.hasNext())
			c1 = it.next();
		while(it.hasNext()) {
			Comparable c2 = it.next();
			if(c1.compareTo(c2)> 0) {
				ordered = false;
				break;
			}
				
		}
		return ordered;
	}
	public static void main(String...strings ){
		
	}
}
