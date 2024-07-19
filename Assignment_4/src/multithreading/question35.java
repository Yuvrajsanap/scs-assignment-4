package multithreading;

import java.util.concurrent.Semaphore;

public class question35 {
	private static final Semaphore semaphore = new Semaphore(2);

	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " acquired a permit.");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " released a permit.");
				semaphore.release();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		Thread t3 = new Thread(task, "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}
}
