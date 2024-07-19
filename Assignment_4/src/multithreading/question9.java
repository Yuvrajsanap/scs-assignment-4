package multithreading;

public class question9 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (question9.class) {
				try {
					System.out.println("Thread 1 is waiting...");
					question9.class.wait();
					System.out.println("Thread 1 is resumed...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (question9.class) {
				try {
					System.out.println("Thread 2 is waiting...");
					question9.class.wait();
					System.out.println("Thread 2 is resumed...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (question9.class) {
			// question9.class.notify(); // notify() method
			question9.class.notifyAll(); // notifyAll() method
		}
	}
}
