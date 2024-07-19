package multithreading;

public class question38 {
	public static void main(String[] args) {
		Thread thread = new Thread() {
			// No run() method overridden
		};

		thread.start();
		System.out.println("Thread started but did nothing");
	}
}
