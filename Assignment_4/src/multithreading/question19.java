package multithreading;

public class question19 {
	public synchronized void instanceMethod() {
		System.out.println("Instance method executed by " + Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void staticMethod() {
		System.out.println("Static method executed by " + Thread.currentThread().getName());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		question19 obj = new question19();

		Thread t1 = new Thread(obj::instanceMethod, "Thread-1");
		Thread t2 = new Thread(question19::staticMethod, "Thread-2");

		t1.start();
		t2.start();
	}
}
