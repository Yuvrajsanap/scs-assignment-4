package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class question24 {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

		Thread producer = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					queue.put(i);
					System.out.println("Produced: " + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					int value = queue.take();
					System.out.println("Consumed: " + value);
					Thread.sleep(1500);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		producer.start();
		consumer.start();
	}
}
