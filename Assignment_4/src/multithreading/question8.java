package multithreading;

public class question8 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (question8.class) {
				try {
					System.out.println("Thread is waiting...");
					question8.class.wait(); // wait() method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread is resumed...");
			}
		});

		t1.start();

		Thread.sleep(2000); // sleep() method

		synchronized (question8.class) {
			question8.class.notify(); // notify() method
		}
	}
}
