package multithreading;

public class question22 {
	public static void main(String[] args) {
		Thread highPriorityThread = new Thread(() -> {
			while (true) {
				System.out.println("High priority thread running");
			}
		});

		Thread lowPriorityThread = new Thread(() -> {
			while (true) {
				System.out.println("Low priority thread running");
			}
		});

		highPriorityThread.setPriority(Thread.MAX_PRIORITY);
		lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

		highPriorityThread.start();
		lowPriorityThread.start();
	}
}
