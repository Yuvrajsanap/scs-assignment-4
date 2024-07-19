package multithreading;

public class question31 {
	private static volatile boolean flag = false;

	public static void main(String[] args) {
		Thread spinner = new Thread(() -> {
			while (!flag) {
				// Busy spinning
			}
			System.out.println("Flag is set, thread is exiting");
		});

		Thread setter = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			flag = true;
			System.out.println("Flag is set by setter thread");
		});

		spinner.start();
		setter.start();
	}
}
