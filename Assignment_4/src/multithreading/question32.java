package multithreading;

public class question32 {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();

		Thread t1 = new Thread(() -> sharedResource.synchronizedMethod());
		Thread t2 = new Thread(() -> sharedResource.synchronizedBlock());

		t1.start();
		t2.start();
	}
}

class SharedResource {
	public synchronized void synchronizedMethod() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Synchronized Method: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void synchronizedBlock() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Synchronized Block: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
