package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.istack.internal.logging.Logger;

public class Collections {
	
	private static Logger log = Logger.getLogger(Collections.class);
	
	public static void main(String...strings) {
		Map<Long, String> idNameMap = new TreeMap<>();
		
		AtomicLong id = new AtomicLong(0);
		idNameMap.put(id.incrementAndGet(), "Christian");
		idNameMap.put(id.incrementAndGet(), "Francesco");
		idNameMap.put(id.incrementAndGet(), "Antonio");
		idNameMap.put(id.incrementAndGet(), "Marco");
		
		Iterator<Entry<Long, String>> it = idNameMap.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<Long, String> entry = it.next();
			log.info(entry.getKey() + " : " + entry.getValue() + "\n");
		}
		
	}

}
