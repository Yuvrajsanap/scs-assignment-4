package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class question11 {

	// Runnable implementation
	static class MyRunnable implements Runnable {
		public void run() {
			System.out.println("Runnable is running...");
		}
	}

	static class MyCallable implements Callable<String> {
		public String call() throws Exception {
			return "Callable result";
		}
	}

	public static void main(String[] args) {

		Thread thread1 = new Thread(new MyRunnable());
		thread1.start();

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(new MyCallable());

		try {
			System.out.println("Callable returned: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}
