package multithreading;

public class question34 {
	private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	public static void main(String[] args) {
		Runnable task = () -> {
			int value = threadLocal.get();
			System.out.println(Thread.currentThread().getName() + " - Initial value: " + value);
			threadLocal.set(value + 1);
			System.out.println(Thread.currentThread().getName() + " - Modified value: " + threadLocal.get());
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}
}
