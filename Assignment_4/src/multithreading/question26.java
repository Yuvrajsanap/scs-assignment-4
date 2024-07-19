package multithreading;

public class question26 {
	public static void main(String[] args) {
		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Count: " + i);
				try {
					Thread.sleep(100); // Simulate some work
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}
}
