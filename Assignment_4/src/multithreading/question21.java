package multithreading;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class question21 {
	public static void main(String[] args) {
		// Hashtable example
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "A");
		hashtable.put(2, "B");
		System.out.println("Hashtable: " + hashtable);

		// ConcurrentHashMap example
		ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(1, "A");
		concurrentHashMap.put(2, "B");
		System.out.println("ConcurrentHashMap: " + concurrentHashMap);
	}
}
