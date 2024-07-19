package multithreading;

public class question20 {
	public static void main(String[] args) {
		question20 obj = new question20();
		obj = null;

		System.gc();
		System.out.println("Garbage Collection triggered");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
	}
}
