package multithreading;

public class question23 {
	private static class Resource {
		private volatile boolean locked = false;

		public synchronized void lock() {
			locked = true;
		}

		public synchronized void unlock() {
			locked = false;
		}

		public boolean isLocked() {
			return locked;
		}
	}

	public static void main(String[] args) {
		final Resource resource1 = new Resource();
		final Resource resource2 = new Resource();

		Thread t1 = new Thread(() -> {
			while (true) {
				if (!resource1.isLocked()) {
					resource1.lock();
					if (resource2.isLocked()) {
						resource1.unlock();
					} else {
						resource2.lock();
						break;
					}
				}
			}
			System.out.println("Thread 1 finished");
		});

		Thread t2 = new Thread(() -> {
			while (true) {
				if (!resource2.isLocked()) {
					resource2.lock();
					if (resource1.isLocked()) {
						resource2.unlock();
					} else {
						resource1.lock();
						break;
					}
				}
			}
			System.out.println("Thread 2 finished");
		});

		t1.start();
		t2.start();
	}
}
