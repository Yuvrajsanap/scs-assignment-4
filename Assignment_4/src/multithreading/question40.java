package multithreading;

public class question40 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " is running");
		});

		thread.run();
		thread.start();
	}
}
