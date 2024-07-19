package multithreading;

public class question7 extends Thread {
	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Daemon thread running...");
		} else {
			System.out.println("User thread running...");
		}
	}

	public static void main(String[] args) {
		question7 t1 = new question7();
		question7 t2 = new question7();
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}
