package multithreading;

public class question16 {
	static class Resource {
		public synchronized void method1(Resource resource) {
			System.out.println(Thread.currentThread().getName() + ": method1");
			resource.method2();
		}

		public synchronized void method2() {
			System.out.println(Thread.currentThread().getName() + ": method2");
		}
	}

	public static void main(String[] args) {
		final Resource resource1 = new Resource();
		final Resource resource2 = new Resource();

		Thread t1 = new Thread(() -> resource1.method1(resource2), "Thread-1");
		Thread t2 = new Thread(() -> resource2.method1(resource1), "Thread-2");

		t1.start();
		t2.start();
	}
}
