package multithreading;

// Class lock and object lock example
public class question5 {
	// Class lock
	public static synchronized void classLock() {
		System.out.println("Class lock obtained by thread: " + Thread.currentThread().getName());
	}

	// Object lock
	public synchronized void objectLock() {
		System.out.println("Object lock obtained by thread: " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		question5 obj1 = new question5();
		question5 obj2 = new question5();

		new Thread(question5::classLock, "Thread-1").start();
		new Thread(question5::classLock, "Thread-2").start();

		new Thread(obj1::objectLock, "Thread-3").start();
		new Thread(obj2::objectLock, "Thread-4").start();
	}
}
