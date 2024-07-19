package multithreading;

public class question41 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			printNumbers();
		}, "Thread-1");

		Thread t2 = new Thread(() -> {
			printNumbers();
		}, "Thread-2");

		t1.start();
		t2.start();
	}

	public static void printNumbers() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Count: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
