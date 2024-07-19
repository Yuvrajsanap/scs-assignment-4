package multithreading;

public class question42 {
	private int counter = 0;

	public synchronized void increment() {
		counter++;
	}

	public static void main(String[] args) {
		question42 example = new question42();

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				example.increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Final Counter Value: " + example.counter);
	}
}
