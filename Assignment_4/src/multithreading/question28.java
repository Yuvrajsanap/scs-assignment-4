package multithreading;

public class question28 {
	public static void main(String[] args) {
		final Object lock = new Object();

		Thread producer = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Producer is producing");
				try {
					Thread.sleep(1000);
					lock.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("Consumer is waiting");
					lock.wait();
					System.out.println("Consumer is consuming");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		consumer.start();
		producer.start();
	}
}
