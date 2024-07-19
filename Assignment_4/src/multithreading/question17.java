package multithreading;

public class question17 extends Thread {
	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Thread is running...");
		}
		System.out.println("Thread stopped.");
	}

	public void stopRunning() {
		running = false;
	}

	public static void main(String[] args) {
		question17 t = new question17();
		t.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t.stopRunning();
	}
}
