package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class question27 {
	public static void main(String[] args) throws InterruptedException {
		// CountDownLatch example
		CountDownLatch latch = new CountDownLatch(3);
		Runnable worker = () -> {
			System.out.println(Thread.currentThread().getName() + " is working");
			latch.countDown();
		};

		new Thread(worker, "Worker-1").start();
		new Thread(worker, "Worker-2").start();
		new Thread(worker, "Worker-3").start();

		latch.await();
		System.out.println("All workers have finished their jobs");

		// CyclicBarrier example
		CyclicBarrier barrier = new CyclicBarrier(3, () -> {
			System.out.println("All parties have arrived at the barrier, let's play");
		});

		Runnable barrierWorker = () -> {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		new Thread(barrierWorker, "Thread-1").start();
		new Thread(barrierWorker, "Thread-2").start();
		new Thread(barrierWorker, "Thread-3").start();
	}
}
