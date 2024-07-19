package multithreading;

public class question2 extends Thread {
	public void run() {
		System.out.println("Thread is running...");
	}

	public static void main(String[] args) {
		question2 t1 = new question2();
		t1.start();
	}
}
