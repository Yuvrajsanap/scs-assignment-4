package multithreading;

public class question6 extends Thread {
	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Daemon thread running...");
		} else {
			System.out.println("User thread running...");
		}
	}

	public static void main(String[] args) {
		question6 t1 = new question6();
		question6 t2 = new question6(); // Daemon thread

		t2.setDaemon(true); // Setting t2 as Daemon thread

		t1.start();
		t2.start();
	}
}
