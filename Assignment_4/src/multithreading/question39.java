package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class question39 {
	private final Lock lock = new ReentrantLock();

	public void performTask() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is performing a task");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		question39 example = new question39();

		Runnable task = example::performTask;

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}
}
