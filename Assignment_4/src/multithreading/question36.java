package multithreading;

public class question36 {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("My Thread Group");

		Thread t1 = new Thread(group, () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		}, "Thread-1");

		Thread t2 = new Thread(group, () -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		}, "Thread-2");

		t1.start();
		t2.start();

		System.out.println("Active threads in group: " + group.activeCount());
	}
}
