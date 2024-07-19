package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class question37 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Runnable task1 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Task 1 - Count: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		Runnable task2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " - Task 2 - Count: " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		executorService.submit(task1);
		executorService.submit(task2);

		executorService.shutdown();
	}
}
