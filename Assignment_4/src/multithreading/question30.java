package multithreading;

public class question30 {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutdown hook is running");
		}));

		System.out.println("Main thread is running");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Main thread is exiting");
	}
}
