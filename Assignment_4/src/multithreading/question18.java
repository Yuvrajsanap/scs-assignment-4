package multithreading;

public class question18 {
	public static void main(String[] args) {
		final Object lock = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("Thread 1 waiting...");
					lock.wait();
					System.out.println("Thread 1 resumed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Thread 2 notifying...");
				lock.notify();
			}
		});

		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
