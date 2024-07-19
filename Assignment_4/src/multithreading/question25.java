package multithreading;

public class question25 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("Thread is running");
		});

		thread.start();

		try {
			thread.start();
		} catch (IllegalThreadStateException e) {
			System.out.println("Exception: " + e);
		}
	}
}
