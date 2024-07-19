package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class question13 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}
}

class WorkerThread implements Runnable {
	private String message;

	public WorkerThread(String message) {
		this.message = message;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
		processMessage();
		System.out.println(Thread.currentThread().getName() + " (End)");
	}

	private void processMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
