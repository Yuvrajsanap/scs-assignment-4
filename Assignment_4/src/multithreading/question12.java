package multithreading;

public class question12 {
	private int count = 0;

	// Synchronized Method
	public synchronized void incrementSynchronizedMethod() {
		count++;
	}

	// Synchronized Block
	public void incrementSynchronizedBlock() {
		synchronized (this) {
			count++;
		}
	}

	public static void main(String[] args) {
		question12 obj = new question12();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				obj.incrementSynchronizedMethod();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				obj.incrementSynchronizedBlock();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count: " + obj.count);
	}
}
