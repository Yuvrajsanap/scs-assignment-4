package multithreading;

// shutdown hook
public class question10 {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutdown Hook is running!");
			performCleanup();
		}));

		System.out.println("Application is running...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Application is terminating...");
	}

	private static void performCleanup() {
		System.out.println("Performing cleanup tasks...");

	}
}
