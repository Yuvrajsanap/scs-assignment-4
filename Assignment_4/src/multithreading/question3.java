package multithreading;

class ThreadExample extends Thread {
	public void run() {
		System.out.println("Thread using Thread class is running...");
	}
}

// Implementing Runnable interface
class RunnableExample implements Runnable {
	public void run() {
		System.out.println("Thread using Runnable interface is running...");
	}
}

public class question3 {
	public static void main(String[] args) {

		ThreadExample thread1 = new ThreadExample();
		thread1.start();

		RunnableExample runnableExample = new RunnableExample();
		Thread thread2 = new Thread(runnableExample);
		thread2.start();
	}
}
